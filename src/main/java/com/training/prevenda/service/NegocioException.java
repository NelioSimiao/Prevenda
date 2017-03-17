package com.training.prevenda.service;

public class NegocioException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NegocioException( String mgs) {
		super(mgs);
	}

}
