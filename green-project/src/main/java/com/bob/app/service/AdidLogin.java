package com.bob.app.service;


import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bob.app.api.rest.GeneralController;
import com.bob.app.utils.CommonUtils;
import com.bob.app.utils.UserLoginRespModel;




@Service
public class AdidLogin {
	private static Logger log = LoggerFactory.getLogger(AdidLogin.class);

	private static final String LDAP_CTX_FACTORY_INIT_VALUE="com.sun.jndi.ldap.LdapCtxFactory";
	private static final String LDAP_REQ_AUTH_MODE="simple";
	private static final String LDAP_REQ_REFERRAL="follow";
	private static final String LDAP_REQ_DOMAIN="bankofbaroda\\";
	private static final String LDAP_USERID_NAME_ATTR="sAMAccountName";
	private static final String LDAP_DISPLAY_NAME_ATTR="displayName";
	private static final String LDAP_BR_ALPHA_ATTR="physicalDeliveryOfficeName";
	private static final String LDAP_ROLE_ATTR="title";	
	private static final String LDAP_ORGANISATION_ATTR="company";

	
	private static  String processRequest(InitialLdapContext ctx, String userContext, String filter, String attribute) {

		String attrValue              = null;
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		NamingEnumeration<SearchResult> searchResults;
		try {
			searchResults = ctx.search(userContext, filter, searchControls);
			

			while (searchResults.hasMoreElements()) {
				
				SearchResult sr = searchResults.next();
				Attributes attributes = sr.getAttributes();		
				Attribute a = attributes.get(attribute);

				if (a != null) {
					attrValue = (a.get().toString());
					return attrValue;
				} else {					
					return null;
				}
			}
		} catch (NamingException e) {
			
			log.error("error : "+e);
		}
		catch (Exception e) {
			log.error("error : "+e);
		}
		return attrValue;
	}

	public boolean adidCheckerBoolean(String userName, String password)
	{
		
		try
		{
			password = CommonUtils.getDecryptedData(password);			
		}
		catch(Exception e)
		{
			log.error("error : "+e);
			return false;
		}
		
		
		boolean retVar=false;
		
		try
		{
			Properties properties = new Properties();
			properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, LDAP_CTX_FACTORY_INIT_VALUE);
			properties.put(javax.naming.Context.PROVIDER_URL,"LDAP://172.16.4.132");
			properties.put(javax.naming.Context.SECURITY_AUTHENTICATION, LDAP_REQ_AUTH_MODE);
			properties.put(javax.naming.Context.REFERRAL, LDAP_REQ_REFERRAL);
			properties.put(javax.naming.Context.SECURITY_PRINCIPAL, LDAP_REQ_DOMAIN + userName); 
			properties.put(javax.naming.Context.SECURITY_CREDENTIALS, password);
			
			InitialLdapContext ctx = null;
			
			
			try {
				ctx = new InitialLdapContext(properties, null);
				String user_id = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_USERID_NAME_ATTR);
				String user_name = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_DISPLAY_NAME_ATTR);
				String branch_alpha = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_BR_ALPHA_ATTR);
				String user_role = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_ROLE_ATTR);			
				String user_org = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_ORGANISATION_ATTR);
				
				
				retVar = true;
			}
			catch(AuthenticationException e) {
				log.error("error : "+e);
				
			} catch (NamingException e) {
				log.error("error : "+e);
				
			} catch(Exception e) {
				log.error("error : "+e);
				
			}			
			
		}
		catch(Exception e)
		{
			log.error("error : "+e);
			
		}
		
		
		return retVar;
//		retVar = true;
//		return retVar;
	}

	
	public UserLoginRespModel adidLoginInfo(String userName, String password)
	{

		
		try
		{
			password = CommonUtils.getDecryptedData(password);			
		}
		catch(Exception e)
		{
			log.error("error : "+e);
			return null;
		}
		
		
		UserLoginRespModel adResponse=new UserLoginRespModel();
		
		try
		{
			Properties properties = new Properties();
			properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, LDAP_CTX_FACTORY_INIT_VALUE);
			properties.put(javax.naming.Context.PROVIDER_URL, "LDAP://172.16.4.132");
			properties.put(javax.naming.Context.SECURITY_AUTHENTICATION, LDAP_REQ_AUTH_MODE);
			properties.put(javax.naming.Context.REFERRAL, LDAP_REQ_REFERRAL);
			properties.put(javax.naming.Context.SECURITY_PRINCIPAL, LDAP_REQ_DOMAIN + userName); 
			properties.put(javax.naming.Context.SECURITY_CREDENTIALS, password);
			
			InitialLdapContext ctx = null;
			
			
			try {
				ctx = new InitialLdapContext(properties, null);
				String user_id = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_USERID_NAME_ATTR);
				String user_name = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_DISPLAY_NAME_ATTR);
				String branch_alpha = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_BR_ALPHA_ATTR);
				String user_role = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_ROLE_ATTR);			
				String user_org = processRequest(ctx, "dc=bankofbaroda,dc=co,dc=in", "(sAMAccountName="+userName+")", LDAP_ORGANISATION_ATTR);
					
				
				
				adResponse.setBrAplha(branch_alpha);
				adResponse.setEcNo(user_id);
				adResponse.setEmpName(user_name);
				adResponse.setPosition(user_role);
			}
			catch(AuthenticationException e) {
				log.error("error : "+e);
			} catch (NamingException e) {
				log.error("error : "+e);
				
			} catch(Exception e) {
				log.error("error : "+e);
				
			}			
			
		}
		catch(Exception e)
		{
			log.error("error : "+e);
			
		}
		
		
		return adResponse;
	}
}
