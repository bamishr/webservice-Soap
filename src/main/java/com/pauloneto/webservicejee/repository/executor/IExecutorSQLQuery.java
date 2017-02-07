package com.pauloneto.webservicejee.repository.executor;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

public interface IExecutorSQLQuery<T> {

	
	public T executarSQLQueryUnique(String consulta,Map<String,Object> parametros, Map<String,Type> scalar, Class<T> clazz);
	public List<T> executarSQLQuery(String consulta,Map<String,Object> parametros, Map<String,Type> scalar, Class<T> clazz);
}
