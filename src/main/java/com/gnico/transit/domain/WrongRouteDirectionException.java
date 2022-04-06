package com.gnico.transit.domain;

public class WrongRouteDirectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public WrongRouteDirectionException(String errorMessage) {
		super(errorMessage);
	}

	public WrongRouteDirectionException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
