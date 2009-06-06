import static org.junit.Assert.*;

import org.junit.Test;

import domain.utils.MD5Encrypter;


public class EncriptionTester {

	@Test
	public void testEncryptMD5() {
		String toEnc = ""; // Value to encrypt
		String md5 = MD5Encrypter.encryptMD5(toEnc);
		assertEquals("d41d8cd98f00b204e9800998ecf8427e", md5);
		
		toEnc = "esta es una cadena a encriptar";
		md5 = MD5Encrypter.encryptMD5(toEnc);
		assertEquals("20721eaf1a89669667548d888b9e30f", md5);
		
		toEnc = "Encrypt This!";
		md5 = MD5Encrypter.encryptMD5(toEnc);
		assertEquals("f9d41544906ad8dcd30332e585cfaae9", md5);
	}

}
