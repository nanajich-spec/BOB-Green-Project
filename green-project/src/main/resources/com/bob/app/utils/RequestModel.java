package com.bob.app.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;


@ToString
public class RequestModel<T> {
	@JsonProperty("request")
	private T reqData;

	public T getReqData() {
		return reqData;
	}

	public void setReqData(T reqData) {
		this.reqData = reqData;
	}
}
