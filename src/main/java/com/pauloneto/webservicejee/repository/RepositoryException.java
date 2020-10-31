package com.pauloneto.webservicejee.repository;

import com.pauloneto.webservicejee.mesages.MesagesProperties;

public class RepositoryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositoryException() {
		super();
	}

	public RepositoryException(Exception exc) {
		super(exc);
	}
	
	public RepositoryException(String key){
		super(MesagesProperties.getInstancia().getMesage(key));
	}
	
	public RepositoryException(String key, String... argumentos){
		super(MesagesProperties.getInstancia().getMesage(key,argumentos));
	}
	
	public RepositoryException(String key, Throwable throwable){
		super(MesagesProperties.getInstancia().getMesage(key), throwable);
	}
	
	public RepositoryException(String key, Throwable throwable, String... argumentos){
		super(MesagesProperties.getInstancia().getMesage(key,argumentos), throwable);
	}

}
