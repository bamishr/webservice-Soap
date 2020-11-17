package com.pauloneto.webservicejee.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.pauloneto.webservicejee.busines.impl.PerfilBusines;
import com.pauloneto.webservicejee.dto.PerfilDTO;
import com.pauloneto.webservicejee.models.Perfil;
import com.pauloneto.webservicejee.ws.IPerfilWs;
import com.pauloneto.webservicejee.ws.WebServiceGeneric;

@WebService(endpointInterface = "com.pauloneto.webservicejee.ws.IPerfilWs")
public class PerfilWsImpl extends WebServiceGeneric<PerfilDTO, Perfil> implements IPerfilWs {

	@Resource
    private WebServiceContext wsctx;
	
	@Inject
	private PerfilBusines perfilBusines;
	
	@Override
	public List<PerfilDTO> obterTodosPerfis() {
		return gerarListaProdutos();
	}

	private List<PerfilDTO> gerarListaProdutos() {
		List<PerfilDTO> perfils = new ArrayList<PerfilDTO>();
		PerfilDTO p1 = new PerfilDTO(1L,"Admin");
		PerfilDTO p2 = new PerfilDTO(2L,"Programer");
		PerfilDTO p3 = new PerfilDTO(3L,"DBA");
		perfils.add(p1);
		perfils.add(p2);
		perfils.add(p3);
		return perfils;
		PerfilDTO p3 = new PerfilDTO(3L,"DBA");
		perfils.add(p1);
		perfils.add(p2);
		perfils.add(p3);
		return perfils;
		PerfilDTO p3 = new PerfilDTO(3L,"DBA");
		perfils.add(p1);
		perfils.add(p2);
		perfils.add(p3);
		return perfils;
	}

}
