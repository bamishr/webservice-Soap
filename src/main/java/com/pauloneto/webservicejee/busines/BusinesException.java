package com.pauloneto.webservicejee.busines;

import com.pauloneto.webservicejee.mesages.MesagesProperties;
import com.pauloneto.webservicejee.mesages.KeyMesages;
import com.pauloneto.webservicejee.models.Perfil;
import com.pauloneto.webservicejee.models.Usuario;
import com.pauloneto.webservicejee.repository.RepositoryException;
import com.pauloneto.webservicejee.repository.impl.PerfilRepository;
import com.pauloneto.webservicejee.util.AssertUtils;
import com.pauloneto.webservicejee.util.HashPasswordUtil;

public class BusinesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinesException() {
		super();
	}

	public BusinesException(Exception exc) {
		super(exc);
	}
	
	public BusinesException(String key){
		super(MesagesProperties.getInstancia().getMesage(key));
	}
	
	public BusinesException(String key, String... argumentos){
		super(MesagesProperties.getInstancia().getMesage(key,argumentos));
	}
	
	public BusinesException(String key, Throwable throwable){
		super(MesagesProperties.getInstancia().getMesage(key), throwable);
	}
	
	public BusinesException(String key, Throwable throwable, String... argumentos){
		super(MesagesProperties.getInstancia().getMesage(key,argumentos), throwable);
	}
}
