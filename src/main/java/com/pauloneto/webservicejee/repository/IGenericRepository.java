/**
 * 
 */
package com.pauloneto.webservicejee.repository;

import java.util.List;

/**
 * Interface que define os métodos de mínimos de manipulação com o
 * Banco de Dados. 
 * @author Paulo Antonio
 */
public interface IGenericRepository<T> {

	/**
	 * Salva uma Entidade.
	 * @param entity
	 * @return
	 * @throws RepositoryException
	 */
	public T save(T entity) throws RepositoryException;
	
	/**
	 * Salva uma Lista de Entidade.
	 * @param entity
	 * @return
	 * @throws RepositoryException
	 */
	public List<T> saveList(List<T> lista)throws RepositoryException;

	/**
	 * Deleta uma Entidade.
	 * @param entity
	 * @return
	 * @throws RepositoryException
	 */
	public void delete(T entity)throws RepositoryException;

	/**
	 * Altera uma Entidade.
	 * @param entity
	 * @return
	 * @throws RepositoryException
	 */
	public T update(T entity)throws RepositoryException;

	/**
	 * Consulta uma Entidade pelo id.
	 * @param entity
	 * @return
	 * @throws RepositoryException
	 */
	public T findId(Class<T> clazz,Long entityID);
	
	/**
	 * Atualiza uma Lista de entidade
	 * @param lista
	 * @return
	 * @throws RepositoryException
	 */
	public List<T> updateList(List<T> lista)throws RepositoryException;
	
	/**
	 * Consulta todos os registros
	 * @param t
	 * @return
	 */
	public List<T> findAll(Class<T> t);
}
