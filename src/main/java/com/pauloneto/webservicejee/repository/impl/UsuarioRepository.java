package com.pauloneto.webservicejee.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.pauloneto.webservicejee.models.Usuario;
import com.pauloneto.webservicejee.repository.GenericRepositoryImpl;

public class UsuarioRepository extends GenericRepositoryImpl<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Usuario> findAll() {
		List<Usuario> retorno = new ArrayList<>();
		StringBuilder consulta = new StringBuilder("select u from Usuario u");
		try{
			TypedQuery<Usuario> query = entityManager.createQuery(consulta.toString(), Usuario.class);
			retorno = query.getResultList();
		}catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return retorno;
	}

	public Usuario buscarPorLoginSenha(String login, String senha) {
		Usuario retorno = null;
		StringBuilder consulta = new StringBuilder("select u from Usuario u where u.login = :login and u.senha = :senha");
		try{
			TypedQuery<Usuario> query = entityManager.createQuery(consulta.toString(), Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha",senha);
			retorno = query.getSingleResult();
		}catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return retorno;
	}
}
