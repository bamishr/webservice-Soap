package com.pauloneto.webservicejee.busines.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.pauloneto.webservicejee.busines.BusinesException;
import com.pauloneto.webservicejee.busines.BusinessGeneric;
import com.pauloneto.webservicejee.dto.UsuarioDTO;
import com.pauloneto.webservicejee.mesages.KeyMesages;
import com.pauloneto.webservicejee.models.Perfil;
import com.pauloneto.webservicejee.models.Usuario;
import com.pauloneto.webservicejee.repository.RepositoryException;
import com.pauloneto.webservicejee.repository.impl.PerfilRepository;
import com.pauloneto.webservicejee.util.AssertUtils;
import com.pauloneto.webservicejee.util.HashPasswordUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UsuarioBusines extends BusinessGeneric<Usuario,UsuarioDTO >{
	
	@Inject
	private PerfilRepository perfilRepository;
	
	@Inject
	private HashPasswordUtil hashPasswordUtil;
	
	public List<Usuario> listar(){
		return repository.findAll(Usuario.class);
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario salvar(UsuarioDTO usuario) throws BusinesException{
		String hashedPwd = hashPasswordUtil.generateHash(usuario.getSenha());
		usuario.setSenha(hashedPwd);
		try{
			Usuario u = converter.toEntidade(usuario);
			u.setId(null);
			return repository.save(u);
		}catch (RepositoryException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			throw new BusinesException(e);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Long codigo) throws BusinesException {
		Usuario u = repository.findId(Usuario.class, codigo);
		try {
			repository.delete(u);
		} catch (RepositoryException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			throw new BusinesException(KeyMesages.ERRO_GENERICO,ExceptionUtils.getRootCauseMessage(e));
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario atualizar(Long codigo, UsuarioDTO usuario) throws BusinesException {
		Usuario usuarioEncontrado = repository.findId(Usuario.class, codigo);
		if (AssertUtils.isEmpty(usuarioEncontrado)) {
			String arg[] = {codigo.toString()};
			throw new BusinesException(KeyMesages.USUARIO_NAO_ENCONTRADO,arg);
		}
		try {
			BeanUtils.copyProperties(usuarioEncontrado, usuario);
			usuarioEncontrado.setId(codigo);
			return repository.update(usuarioEncontrado);
		} catch (IllegalAccessException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			throw new BusinesException(KeyMesages.ERRO_GENERICO,ExceptionUtils.getRootCauseMessage(e));
		} catch (InvocationTargetException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			throw new BusinesException(KeyMesages.ERRO_GENERICO,ExceptionUtils.getRootCauseMessage(e));
		} catch (RepositoryException e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			throw new BusinesException(KeyMesages.ERRO_GENERICO,ExceptionUtils.getRootCauseMessage(e));
		}
	}

	@Override
	public List<Usuario> listar(Class<Usuario> clazz){
		return repository.findAll(clazz);
	}

	@Override
	public Usuario obterPorId(Long codigo) {
		return repository.findId(Usuario.class, codigo);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionaPerfilaUsuario(Long codigoPerfil, Long codigoUsuario) throws BusinesException {
		Perfil perfilEncontrado = perfilRepository.findId(Perfil.class, codigoPerfil);
		if(AssertUtils.isEmpty(perfilEncontrado)){
			String arg[] = {codigoPerfil.toString()};
			throw new BusinesException(KeyMesages.PERFIL_NAO_ENCONTRADO,arg);
		}
		Usuario usuarioEncontrado = repository.findId(Usuario.class, codigoUsuario);
		if(AssertUtils.isEmpty(usuarioEncontrado)){
			String arg[] = {codigoUsuario.toString()};
			throw new BusinesException(KeyMesages.USUARIO_NAO_ENCONTRADO,arg);
		}
		usuarioEncontrado.getPerfis().add(perfilEncontrado);
		try {
			repository.update(usuarioEncontrado);
		} catch (RepositoryException e) {
			throw new BusinesException(KeyMesages.ERRO_GENERICO,ExceptionUtils.getRootCauseMessage(e));
		}
	}

	public List<Perfil> consultarPerfisDoUsuario(Long codigoUsuario){
		return perfilRepository.consultarPerfisDoUsuario(codigoUsuario);
	}
	
}
