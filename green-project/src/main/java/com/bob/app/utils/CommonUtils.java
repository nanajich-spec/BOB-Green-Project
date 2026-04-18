package com.bob.app.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bob.app.utils.RequestModel;
import com.bob.app.utils.ResponseModel;
import com.bob.app.utils.ResponseModel.APIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import sun.misc.BASE64Encoder;

@Service
public class CommonUtils {
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	// ================================================CRYPTO
	// UTILS======================================================
	public static String getDecryptedData(String data) throws IOException {
		String base64DecodedPassword = new String(decodeBase64(data), "UTF-8");
		String decryptedPassword = "";
		for (int i = 0; i < base64DecodedPassword.length(); i++) {
			decryptedPassword += (char) (base64DecodedPassword.charAt(i) + 10);
		}
		return decryptedPassword;
	}

	public static String getEncryptedData(String data) throws UnsupportedEncodingException {
		String encryptedPassword = "";
		for (int i = 0; i < data.length(); i++) {
			encryptedPassword += (char) (data.charAt(i) - 10);
		}
		String base64EncodedEncryptedPassword = encodeBase64(encryptedPassword.getBytes("UTF-8"));
		return base64EncodedEncryptedPassword;
	}

	private static byte[] decodeBase64(String base64String) throws IOException {
		return Base64.decode(base64String);
	}

	private static String encodeBase64(byte[] bytes) {
		return Base64.encode(bytes);
	}

	public static String callRestWS(String url, String password, String reqContentType, String respContentType,
			String requestStr) { 
									
		logger.info("Inside Api Call to URL:-" + url);
		logger.info("API Request-" + requestStr);
		String responseStr = null;
		String passStringEnc = new BASE64Encoder().encode(password.getBytes());
		Client client = Client.create();
		WebResource packResource = client.resource(url);
		responseStr = packResource.accept(respContentType).header("Content-type", reqContentType)
				.header("Authorization", passStringEnc).post(String.class, requestStr);
//		logger.info("API Response-" + responseStr);
		return responseStr;
	}

	public static void disableSslVerification() {
		try {
			
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					

				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					

				}
			} };

			
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			
			logger.error("error : "+e);
		} catch (KeyManagementException e) {
			logger.error("error : "+e);
		}
	}

	public static String callRestWSGet(String url, String password, String reqContentType, String respContentType) {
		
		String responseStr = null;
		String passStringEnc = new BASE64Encoder().encode(password.getBytes());
		Client client = Client.create();
		WebResource packResource = client.resource(url);
		responseStr = packResource.accept(respContentType).header("Content-type", reqContentType)
				.header("Authorization", passStringEnc).get(String.class);
		return responseStr;
	}

	public String createJsonResponse(String resp_code, Object value) {
		String response = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			APIResponse<Object> apiResp = new APIResponse<Object>();
			apiResp.setResponseCode(resp_code);
			apiResp.setResponseValue(value);

			ObjectNode requestNode = mapper.createObjectNode();
			JsonNode node = mapper.convertValue(apiResp, JsonNode.class);
			requestNode.set("response", node);


			response = mapper.writeValueAsString(requestNode);
		} catch (Exception e) {
			logger.error("Exception while creating JSON response : ", e);
		}
		return response;
	}

	public String createJsonRequest(Object value) {
		String response = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode requestNode = mapper.createObjectNode();
			JsonNode node = mapper.convertValue(value, JsonNode.class);
			requestNode.set("request", node);
	
			response = mapper.writeValueAsString(requestNode);
		} catch (Exception e) {
			logger.error("Exception while creating JSON request String : ", e);
		}
		return response;
	}

	public String createJsonStr(String reqHeader, Object value) {
		String response = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode requestNode = mapper.createObjectNode();
			JsonNode node = mapper.convertValue(value, JsonNode.class);
			requestNode.set(reqHeader, node);
	
			response = mapper.writeValueAsString(requestNode);
		} catch (Exception e) {
			logger.error("Exception while creating JSON request String : ", e);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public <T> T getResponseObjectFromJson(String jsonStr, Class<T> cls)
			throws JsonMappingException, JsonProcessingException {
		T retObj = null;
		try {
			ResponseModel<T> rootObj = null;
			ObjectMapper mapper = new ObjectMapper();
			rootObj = mapper.readValue(jsonStr, ResponseModel.class);
			String str = mapper.writeValueAsString(rootObj.getResp().getResponseValue());
			retObj = mapper.readValue(str, cls);
		} catch (Exception e) {
			logger.error("Exception while getting response object from JSON : ", e);
		}
		return retObj;
	}

	@SuppressWarnings("unchecked")
	public <T> T getReqObjFromJsonStr(String jsonStr, Class<T> cls)
			throws JsonMappingException, JsonProcessingException {

		T retObj = null;
		try {
			RequestModel<T> rootObj = null;
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			rootObj = mapper.readValue(jsonStr, RequestModel.class);
			String str = mapper.writeValueAsString(rootObj.getReqData());
			retObj = mapper.readValue(str, cls);
		} catch (Exception e) {
			logger.error("Exception while getting request object from JSON : ", e);
		}
		return retObj;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getResponseObjectFromJsonList(String jsonStr, Class<T> cls)
			throws JsonMappingException, JsonProcessingException {
		List<T> retObj = null;
		try {
			ResponseModel<T> rootObj = null;
			ObjectMapper mapper = new ObjectMapper();
			rootObj = mapper.readValue(jsonStr, ResponseModel.class);
			String str = mapper.writeValueAsString(rootObj.getResp().getResponseValue());
			retObj = mapper.readValue(str, new TypeReference<List<T>>() {
			});
		} catch (Exception e) {
			logger.error("Exception while getting response list object from JSON : ", e);
		}
		return retObj;
	}

	public String checkResponseStatus(String responseStr) {
		String retStr;
		try {
			@SuppressWarnings("rawtypes")
			ResponseModel respModel = (new ObjectMapper()).readValue(responseStr, ResponseModel.class);
			if (respModel == null || respModel.getResp() == null) {
				retStr = "X";
			} else {
				retStr = respModel.getResp().getResponseCode();
			}
		} catch (Exception e) {
			logger.error("Exception while checking response status is JSON : ", e);
			retStr = "X";
		}

		return retStr;
	}

}
