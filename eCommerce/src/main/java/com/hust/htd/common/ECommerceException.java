package com.hust.htd.common;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author HuyTaDuc
 */

public class ECommerceException extends Exception {

	private static final long serialVersionUID = -8667099008115020045L;

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ECommerceException() {
		super();
	}

	public ECommerceException(String error) {
		super();
		this.error = error;
	}

	@Override
	public String toString() {
		return "ECommerceException [error=" + error + "]";
	}

	@Override
	public void printStackTrace() {
	}

	@Override
	public void printStackTrace(PrintStream printWriter) {
	}

	@Override
	public void printStackTrace(PrintWriter printWriter) {
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTraceElement) {
	}

}
