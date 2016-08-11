package org.walle.webtest.encrypt;

import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * CryptoService
 * @author Changjiang.Wang
 *
 */
public class CryptoService {

	private String salt = "4acfedc7dc72a9003a0dd721d7642bde";
	private String iv = "69135769514102d0eded589ff874cacd";

	/**
	 * decrpt
	 * @return 
	 */
	public String decrpt(String encrypted, String passphrase) throws Exception {
		byte[] saltBytes = hexStringToByteArray(salt);
		byte[] ivBytes = hexStringToByteArray(iv);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec sKey = (SecretKeySpec) generateKeyFromPassword(passphrase, saltBytes);
		return decrypt(encrypted, sKey, ivParameterSpec);
	}

	private SecretKey generateKeyFromPassword(String password, byte[] saltBytes)
			throws GeneralSecurityException {
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), saltBytes, 100, 128);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return new SecretKeySpec(secretKey.getEncoded(), "AES");
	}

	private byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	private String decrypt(String encryptedData, SecretKeySpec sKey,
			IvParameterSpec ivParameterSpec) throws Exception {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, sKey, ivParameterSpec);
		byte[] decordedValue = Base64.decodeBase64(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}
	
}
