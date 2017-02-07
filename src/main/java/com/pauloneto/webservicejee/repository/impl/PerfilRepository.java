package com.pauloneto.webservicejee.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.pauloneto.webservicejee.models.Perfil;
import com.pauloneto.webservicejee.repository.GenericRepositoryImpl;

public class PerfilRepository extends GenericRepositoryImpl<Perfil> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Perfil> consultarPerfisDoUsuario(Long codigoUsuario) {
		List<Perfil> retorno = new ArrayList<>();
		StringBuilder consulta = new StringBuilder("select u.perfis from Usuario u where u.id = :cdUsuario");
		try{
			Query query = entityManager.createQuery(consulta.toString());
			query.setParameter("cdUsuario", codigoUsuario);
			retorno = query.getResultList();
		}catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return retorno;
	}
}
