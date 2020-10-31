package com.pauloneto.webservicejee.ws;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.pauloneto.webservicejee.dto.DTO;

public abstract class WebServiceGeneric<T extends DTO<T>,ENTITY> {
	
	@Inject
	protected Logger logger;

}
