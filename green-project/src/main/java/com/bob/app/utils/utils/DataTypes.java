package com.bob.app.utils.utils;

/**
 * Author : Bitangsha Ray
 * Year : 2019
 */
public class DataTypes {


	public enum reqOriginatorNames
	{
		VALIDATOR("VALIDATOR")
		;				
		private String reqIdentifier;		
		private reqOriginatorNames(String type) {
			this.reqIdentifier = type;
		}
		public String getReqIdentifier() {
			return this.reqIdentifier;
		}		

		@Override
		public String toString() {
			return this.reqIdentifier;
		}

		public static reqOriginatorNames getreqOriginatorNames(String type) {
			for(reqOriginatorNames reqOrg : reqOriginatorNames.values()) {
				if(type.equals(reqOrg.reqIdentifier)) {
					return reqOrg;
				}
			}
			return null;
		}		
	}



	public enum contentTypes
	{
		TEXT ("text/plain"), 
		JSON ("application/json"),	
		XML ("application/xml"),
		OCTET ("application/octet-stream"),
		HTML ("text/html"),
		URLe ("application/x-www-form-urlencoded");

		private String reqIdentifier;		
		private contentTypes(String type) {
			this.reqIdentifier = type;
		}
		public String getReqIdentifier() {
			return this.reqIdentifier;
		}	

		@Override
		public String toString() {
			return this.reqIdentifier;
		}
		public static contentTypes getContentType(String type) {
			for(contentTypes reqOrg : contentTypes.values()) {
				if(type.equals(reqOrg.reqIdentifier)) {
					return reqOrg;
				}
			}
			return null;
		}	
	}





	public enum ResponseCategory {
		SUCCESS("S"), FAILURE("F"), COMPLETED("C"), REJECTED("R"), NOT_FOUND("N"), INVALID("I"), UNAUTHORISED("U");
		private String categoryIndicator;
		private ResponseCategory(String cat) {
			this.categoryIndicator = cat;
		}

		@Override
		public String toString() {
			return this.categoryIndicator;
		}

		public static ResponseCategory getResponseCategory(String identifier) {
			for(ResponseCategory respCat : ResponseCategory.values()) {
				if(identifier.equalsIgnoreCase(respCat.categoryIndicator)) {
					return respCat;
				}
			}
			return null;
		}
	}


	public enum submitStatus{
		COMPLETED,
		PENDING
	}





}

