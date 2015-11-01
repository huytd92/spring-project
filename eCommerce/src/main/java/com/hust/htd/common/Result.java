package com.hust.htd.common;

import org.springframework.http.HttpStatus;

/**
 * @author HuyTaDuc
 */

public class Result<E> {

	private int httpStatus;
	private String message;
	private String error;
	private E data;

	public static <T> Result<T> createResult(HttpStatus status, T data) {
		Result<T> result = new Result<T>();
		result.setData(data);
		result.setHttpStatus(status.value());
		result.setMessage(status.name());
		result.setError(null);
		return result;
	}

	public static <T> Result<T> createResult(HttpStatus status) {
		Result<T> result = new Result<T>();
		result.setData(null);
		result.setHttpStatus(status.value());
		result.setMessage(status.name());
		result.setError(null);
		return result;
	}

	public static <T> Result<T> createResult(HttpStatus status, String error) {
		Result<T> result = new Result<T>();
		result.setData(null);
		result.setHttpStatus(status.value());
		result.setMessage(status.name());
		result.setError(error);
		return result;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Result [httpStatus=" + httpStatus + ", message=" + message + ", error=" + error + ", data=" + data
				+ "]";
	}

}
