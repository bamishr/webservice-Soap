package com.pauloneto.webservicejee.util;

import java.security.MessageDigest;

import javax.inject.Inject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class HashPasswordUtil {

	@Inject
	private Logger logger;

	public String generateHash(String password) {
		return encode(password, "SHA-256");
	}

	public String encode(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getRootCauseMessage(e),e);
			return password;
		}

		md.reset();
		md.update(unencodedPassword);
		byte[] encodedPassword = md.digest();
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10)
				buf.append("0");
			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		return buf.toString();
	}
}
