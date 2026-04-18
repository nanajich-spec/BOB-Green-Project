package com.bob.app.utils;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ResponseModel<T> {
	@JsonProperty("response")
	private APIResponse<T> resp;
	
	public APIResponse<T> getResp() {
		return resp;
	}
	
	public void setResp(APIResponse<T> resp) {
		this.resp = resp;
	}

	public static class APIResponse<T> {		
		
		@JsonProperty("resp_code")
		private String responseCode;
		
		@JsonProperty("resp_value")
		private T responseValue;
		
		public String getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}

		public T getResponseValue() {
			return responseValue;
		}

		public void setResponseValue(T responseValue) {
			this.responseValue = responseValue;
		}	

	}

}
