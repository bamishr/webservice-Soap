package com.pauloneto.webservicejee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class ArquivoUtil {

	@Inject
	private Logger logger;
	
	public Properties getProperties(String propertiesName){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = getClass().getResourceAsStream("/".concat(propertiesName));
			prop.load(input);
		} catch (IOException ex) {
			logger.error(ExceptionUtils.getRootCauseMessage(ex),ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(ExceptionUtils.getRootCauseMessage(e),e);
				}
			}
		}
		return prop;
	}
}
