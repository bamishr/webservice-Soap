package com.pauloneto.webservicejee.busines;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.pauloneto.webservicejee.converter.IWebServiceConverter;
import com.pauloneto.webservicejee.repository.GenericRepositoryImpl;


public abstract class BusinessGeneric<ENTITY,DTO> {

	@Inject
	protected Logger logger;
	
	@Inject
	protected GenericRepositoryImpl<ENTITY> repository;
	
	@Inject
	protected IWebServiceConverter<ENTITY, DTO> converter;

	public abstract ENTITY atualizar(Long codigo, DTO dto) throws BusinesException;

	public abstract ENTITY salvar(DTO dto)throws BusinesException;

	public abstract void remover(Long codigo) throws BusinesException;

	public abstract List<ENTITY> listar(Class<ENTITY> clazz);

	public abstract ENTITY obterPorId(Long codigo);
	@Inject
	protected IWebServiceConverter<ENTITY, DTO> converter;

	public abstract ENTITY atualizar(Long codigo, DTO dto) throws BusinesException;

	public abstract ENTITY salvar(DTO dto)throws BusinesException;

	public abstract void remover(Long codigo) throws BusinesException;

	public abstract List<ENTITY> listar(Class<ENTITY> clazz);

	public abstract ENTITY obterPorId(Long codigo);
	@Inject
	protected IWebServiceConverter<ENTITY, DTO> converter;

	public abstract ENTITY atualizar(Long codigo, DTO dto) throws BusinesException;

	public abstract ENTITY salvar(DTO dto)throws BusinesException;

	public abstract void remover(Long codigo) throws BusinesException;

	public abstract List<ENTITY> listar(Class<ENTITY> clazz);

	public abstract ENTITY obterPorId(Long codigo);@Inject
	protected IWebServiceConverter<ENTITY, DTO> converter;

	public abstract ENTITY atualizar(Long codigo, DTO dto) throws BusinesException;

	public abstract ENTITY salvar(DTO dto)throws BusinesException;

	public abstract void remover(Long codigo) throws BusinesException;

	public abstract List<ENTITY> listar(Class<ENTITY> clazz);

	public abstract ENTITY obterPorId(Long codigo);
}
