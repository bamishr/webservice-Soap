/**
 * 
 */
package com.pauloneto.webservicejee.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.hibernate.type.Type;

import com.pauloneto.webservicejee.mesages.KeyMesages;
import com.pauloneto.webservicejee.repository.executor.IExecutorSQLQuery;
import com.pauloneto.webservicejee.repository.executor.impl.ExecutorSQLQuery;

/**
 * Classe que implementa os métodos de mínimos de manipulação com o Banco de
 * Dados.
 * 
 * @author Paulo Antonio
 * @since quinta-feira 03 11 2016
 */
/**
 * @author paulo-neto
 *
 * @param <T>
 */
public abstract class GenericRepositoryImpl<T> implements IGenericRepository<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163696283184654122L;
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Inject
	protected Logger logger;
	
	
	/* (non-Javadoc)
	 * @see com.apirest.repository.IGenericRepository#save(java.lang.Object)
	 */
	@Override
	public T save(T entity) throws RepositoryException {
		try {
			entityManager.persist(entity);
			return entity;
		} catch (Exception e) {
			throw new RepositoryException(KeyMesages.ERRO_SALVAR, ExceptionUtils.getRootCauseMessage(e));
		}
	}
	
	/* (non-Javadoc)
	 * @see com.apirest.repository.IGenericRepository#saveList(java.util.List)
	 */
	@Override
	public List<T> saveList(List<T> lista)throws RepositoryException{
		int contador = 1;
		List<T> persistedList = new ArrayList<T>();
		for(T t: lista){
			entityManager.persist(t);
			//a cada 50 Entidades, sincroniza e limpa o cache
			if (contador % 50 == 0) {
				entityManager.flush();
				entityManager.clear();
	        }
			contador++;
			persistedList.add(t);
		}
		return persistedList;
	}

	
	/* (non-Javadoc)
	 * @see com.apirest.repository.IGenericRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) throws RepositoryException {
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			throw new RepositoryException(KeyMesages.ERRO_DELETAR, ExceptionUtils.getRootCauseMessage(e));
		}
	}

	
	/* (non-Javadoc)
	 * @see com.apirest.repository.IGenericRepository#update(java.lang.Object)
	 */
	@Override
	public T update(T entity) throws RepositoryException {
		try {
			entity = entityManager.merge(entity);
			return entity;
		} catch (Exception e) {
			throw new RepositoryException(KeyMesages.ERRO_ATUAIZAR, ExceptionUtils.getRootCauseMessage(e));
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.pauloneto.webservicejee.repository.IGenericRepository#updateList(java.util.List)
	 */
	@Override
	public List<T> updateList(List<T> lista)throws RepositoryException{
		int contador = 1;
		List<T> mergedList = new ArrayList<T>();
		for(T t: lista){
			entityManager.merge(t);
			//a cada 50 Entidades, sincroniza e limpa o cache
			if (contador % 50 == 0) {
				entityManager.flush();
				entityManager.clear();
	        }
			contador++;
			mergedList.add(t);
		}
		return mergedList;
	}

	
	/* (non-Javadoc)
	 * @see com.apirest.repository.IGenericRepository#findId(java.lang.Class, java.lang.Long)
	 */
	@Override
	public T findId(Class<T> clazz, Long entityID){
		return entityManager.find(clazz, entityID);
	}
	
	/* (non-Javadoc)
	 * @see com.pauloneto.webservicejee.repository.IGenericRepository#findAll(java.lang.Class)
	 */
	@Override
	public List<T> findAll(Class<T> t) {
		List<T> retorno = new ArrayList<>();
		StringBuilder consulta = new StringBuilder("from "+t.getName()+" t");
		try{
			TypedQuery<T> query = entityManager.createQuery(consulta.toString(), t);
			retorno = query.getResultList();
		}catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
		}
		return retorno;
	}
	
	protected List<T> executaSqlQuery(String consultaSql, Map<String, Object> parametros, Map<String, Type> addScalar,
			Class<T> clazzToTransformer) {
		IExecutorSQLQuery<T> executor = new ExecutorSQLQuery<T>(entityManager);
		return executor.executarSQLQuery(consultaSql, parametros, addScalar, clazzToTransformer);
	}
	
	protected T executaSqlQueryUnique(String consultaSql, Map<String, Object> parametros, Map<String, Type> addScalar,
			Class<T> clazzToTransformer) {
		IExecutorSQLQuery<T> executor = new ExecutorSQLQuery<T>(entityManager);
		return executor.executarSQLQueryUnique(consultaSql, parametros, addScalar, clazzToTransformer);
	}
	
	public T getRefencia(Class<T> clazz, Long entityID){
		return this.entityManager.getReference(clazz, entityID);
	}
	
	public EntityManager geEntityManager(){
		return this.entityManager;
	}
}
