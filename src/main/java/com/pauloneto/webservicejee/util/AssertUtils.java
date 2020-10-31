package com.pauloneto.webservicejee.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilitaria para validacoes simples.
 * Ex: verificar se uma variavel esta vazia ou nula.
 * @author Paulo Antonio
 * @since terça-feira 01 11 2016
 */
public class AssertUtils {
	
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final int TAMANHO_CEP = 8;
	
	private AssertUtils(){}

	/**
	 * Verifica se a {@link Collection} e vazia
	 *
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<? extends Object> collection) {
		return collection == null || collection.isEmpty();
	}
	
	/**
	 * Verifica se o {@link Object} e vazio.
	 * @param objeto
	 * @return boolean
	 */
	public static boolean isEmpty(Object objeto){
		return objeto == null;
	}
	
	/**
	 * Verifica se a {@link String} e vazia
	 *
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
	
	/**
	 * Verifica se o {@link Number} e vazio
	 *
	 * @param number
	 * @return
	 */
	public static boolean isEmpty(Number number) {
		return number == null || number.doubleValue() == 0;
	}
	
	/**
	 * Verifica se o {@link Map} e vazio
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}
	
	/**
	 * Valida se uma string informada é ou não alfanumérica. 
	 * O valor precisa casar com a regra simples A-Za-z0-9. 
	 * Pode ser informado se eh é para considerar espaço em branco como alphanumerico.
	 *
	 * @param email
	 * @return
	 */
	public static boolean isAlfanumerico(String alphastring, boolean escaparEspacoBranco) {
		String regex;
		if (escaparEspacoBranco) {
			regex = "[A-Za-z0-9\\ ]*";
		} else {
			regex = "[A-Za-z0-9]*";
		}
		Pattern pat = Pattern.compile(regex);
		Matcher matcher;
		alphastring = alphastring.trim();
		if (alphastring != null && alphastring.isEmpty()) {
			return false;
		}
		matcher = pat.matcher(alphastring);
		return matcher.matches();
	}
	
	public static boolean isCepFormatoValido(String stringCep) {
		if(isEmpty(stringCep))
			return false;
		if(stringCep.length() != TAMANHO_CEP)
			return false;
		
		Pattern pattern = Pattern.compile("[0-9]{8}");
		Matcher matcher = pattern.matcher(stringCep);
		return matcher.matches();
	}
	
	public static boolean isEmailValido(String email) {
		if(isEmpty(email))
			return false;
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}
