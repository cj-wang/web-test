package org.walle.webtest.encrypt;

import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

/**
 * CryptoService
 * @author Changjiang.Wang
 *
 */
@Service
public class CryptoService {

	private String salt = "4acfedc7dc72a9003a0dd721d7642bde";
	private String iv = "69135769514102d0eded589ff874cacd";

	/**
	 * encrpt
	 * @return 
	 */
	public String encrpt(byte[] plain, String passphrase) throws Exception {
		SecretKeySpec secretKeySpec = (SecretKeySpec) generateKeyFromPassphrase(passphrase, DatatypeConverter.parseHexBinary(salt));
		IvParameterSpec ivParameterSpec = new IvParameterSpec(DatatypeConverter.parseHexBinary(iv));
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		return Base64.encodeBase64String(c.doFinal(plain));
	}

	/**
	 * decrpt
	 * @return 
	 */
	public byte[] decrpt(String encrypted, String passphrase) throws Exception {
		SecretKeySpec secretKeySpec = (SecretKeySpec) generateKeyFromPassphrase(passphrase, DatatypeConverter.parseHexBinary(salt));
		IvParameterSpec ivParameterSpec = new IvParameterSpec(DatatypeConverter.parseHexBinary(iv));
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		return c.doFinal(Base64.decodeBase64(encrypted));
	}

	
	private SecretKey generateKeyFromPassphrase(String passphrase, byte[] saltBytes)
			throws GeneralSecurityException {
		KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), saltBytes, 100, 128);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return new SecretKeySpec(secretKey.getEncoded(), "AES");
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}
	
}
