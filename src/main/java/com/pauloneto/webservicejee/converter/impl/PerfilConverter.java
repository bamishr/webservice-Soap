package com.pauloneto.webservicejee.converter.impl;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.pauloneto.webservicejee.converter.IWebServiceConverter;
import com.pauloneto.webservicejee.dto.PerfilDTO;
import com.pauloneto.webservicejee.models.Perfil;

public class PerfilConverter implements IWebServiceConverter<Perfil, PerfilDTO> {
	
	@Inject
	private Logger logger;
	
	@Override
	public Perfil toEntidade(PerfilDTO dto) {
		Perfil p = new Perfil();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return p;
	}

	@Override
	public PerfilDTO toDto(Perfil entidade) {
		PerfilDTO d = new PerfilDTO();
		try {
			BeanUtils.copyProperties(d, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return d;
	}
@Inject
	private Logger logger;
	
	@Override
	public Perfil toEntidade(PerfilDTO dto) {
		Perfil p = new Perfil();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return p;
	}
	@Inject
	private Logger logger;
	
	@Override
	public Perfil toEntidade(PerfilDTO dto) {
		Perfil p = new Perfil();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return p;
	}
	@Inject
	private Logger logger;
	
	@Override
	public Perfil toEntidade(PerfilDTO dto) {
		Perfil p = new Perfil();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return p;
	}
	@Inject
	private Logger logger;
	
	@Override
	public Perfil toEntidade(PerfilDTO dto) {
		Perfil p = new Perfil();
		try {
			BeanUtils.copyProperties(p, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return p;
	}
}
