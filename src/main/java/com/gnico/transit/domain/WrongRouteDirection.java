package com.gnico.transit.domain;

public class WrongRouteDirection extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public WrongRouteDirection(String errorMessage) {
		super(errorMessage);
	}

	public WrongRouteDirection(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
