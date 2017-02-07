package com.pauloneto.webservicejee.util;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.pauloneto.webservicejee.mesages.KeyMesages;
import com.pauloneto.webservicejee.mesages.MesagesProperties;

public class BeanCDILocator {

	private static BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException ex) {
			throw new RuntimeException(MesagesProperties.getInstancia().getMesage(KeyMesages.BEAN_CDI_NAO_ENC));
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		BeanManager bm = getBeanManager();
		Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(clazz);
		if (beans == null || beans.isEmpty()) {
			return null;
		}
		Bean<T> bean = (Bean<T>) beans.iterator().next();
		CreationalContext<T> ctx = bm.createCreationalContext(bean);
		T o = (T) bm.getReference(bean, clazz, ctx);
		return o;
	}

}
