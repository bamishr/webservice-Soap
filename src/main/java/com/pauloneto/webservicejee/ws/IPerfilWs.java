package com.pauloneto.webservicejee.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.pauloneto.webservicejee.dto.PerfilDTO;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IPerfilWs {

	@WebMethod
	public List<PerfilDTO> obterTodosPerfis();
}
public interface IPerfilWs {

	@WebMethod
	public List<PerfilDTO> obterTodosPerfis();
}