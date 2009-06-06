package domain.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase que se encarga de la encriptación de datos críticos como claves y
 * passwords de usuarios.
 * 
 * @author Aníbal
 * 
 */
public final class MD5Encrypter {

	/**
	 * Método de encriptación por MD5 (algoritmo no reversible)
	 * 
	 * @param input
	 *            String de entrada con los datos a encriptar
	 * @return el resultado de la encriptación en un String
	 */
	public final static String encryptMD5(String input) {
		MessageDigest mdEnc = null;
		try {
			mdEnc = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		mdEnc.update(input.getBytes(), 0, input.length());
		return new BigInteger(1, mdEnc.digest()).toString(16);
	}

}
