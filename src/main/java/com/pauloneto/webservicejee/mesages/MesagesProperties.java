/**
 * 
 */
package com.pauloneto.webservicejee.mesages;

import java.text.MessageFormat;
import java.util.Properties;

import com.pauloneto.webservicejee.util.ArquivoUtil;

/**
 * Classe que acessa as mensagens contidas no arquivo mesages.properties
 * @author Paulo Antonio
 */
public final class MesagesProperties{

	private static String mesagesProperties = "mesages.properties";
	private Properties properties;
	private static final MesagesProperties instancia = new MesagesProperties();
	
	private MesagesProperties(){}
	
	public static MesagesProperties getInstancia() {
		return instancia;
	}

	protected Properties getProperties() {
		if (properties == null) {
			ArquivoUtil arq = new ArquivoUtil();
			properties = arq.getProperties(mesagesProperties);
		}
		return properties;
	}
	
	public String getMesage(String key, String... argumentos){
		String msg =  getProperties().getProperty(key);
		return MessageFormat.format(msg, argumentos);
	}
}
