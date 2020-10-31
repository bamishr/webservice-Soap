package com.pauloneto.webservicejee.repository.executor.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;

import com.pauloneto.webservicejee.repository.executor.IExecutorSQLQuery;

public class ExecutorSQLQuery<T> implements IExecutorSQLQuery<T> {

	
	protected EntityManager entityManager;
	
	public ExecutorSQLQuery(EntityManager em) {
		entityManager = em;
	}
	
	@Override
	public T executarSQLQueryUnique(String consulta, Map<String, Object> parametros, Map<String, Type> scalar,
			Class<T> clazz) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery sqlQuery = session.createSQLQuery(consulta);
		for(String key:parametros.keySet()) {
			if(parametros.get(key) instanceof Set) {
				sqlQuery.setParameterList(key,(Set)parametros.get(key));
			}else if(parametros.get(key) instanceof List) {
				sqlQuery.setParameterList(key,(List)parametros.get(key));
			}else {
				sqlQuery.setParameter(key, parametros.get(key));
			}
		}
		for(String key:scalar.keySet()) {
			sqlQuery.addScalar(key, scalar.get(key));
		}
		sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
		return (T) sqlQuery.uniqueResult();
	}

	@Override
	public List<T> executarSQLQuery(String consulta, Map<String, Object> parametros, Map<String, Type> scalar,
			Class<T> clazz) {
		Session session = entityManager.unwrap(Session.class);
		SQLQuery sqlQuery = session.createSQLQuery(consulta);
		for(String key:parametros.keySet()) {
			if(parametros.get(key) instanceof Set) {
				sqlQuery.setParameterList(key,(Set)parametros.get(key));
			}else if(parametros.get(key) instanceof List) {
				sqlQuery.setParameterList(key,(List)parametros.get(key));
			}else {
				sqlQuery.setParameter(key, parametros.get(key));
			}
		}
		for(String key:scalar.keySet()) {
			sqlQuery.addScalar(key, scalar.get(key));
		}
		sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
		return sqlQuery.list();
	}

}
