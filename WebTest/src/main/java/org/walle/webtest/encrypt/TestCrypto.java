package org.walle.webtest.encrypt;

public class TestCrypto {

	public static void main(String[] args) throws Exception {
		
		CryptoService crypto = new CryptoService();
		
		String passphrase = "hijklmn";
		String encrypted = "BH4UVDog3v8N3s/EJEFdfw==";
		
		String plain = crypto.decrpt(encrypted, passphrase);
		System.out.println(plain);
	}

}
