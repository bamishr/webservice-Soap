package com.pauloneto.webservicejee.converter;

public interface IWebServiceConverter<E, D> {

	public E toEntidade(D dto);
	public D toDto(E entidade);
}
