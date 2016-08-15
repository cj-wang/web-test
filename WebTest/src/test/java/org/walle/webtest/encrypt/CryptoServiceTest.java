package org.walle.webtest.encrypt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.walle.webtest.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CryptoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CryptoService cryptoService;
	
	@Test
	public void test() throws Exception {
		String password = "abcdefg";
		String passphrase = "hijklmn";
		String encrypted = cryptoService.encrpt(password.getBytes(), passphrase);
		String plain = new String(cryptoService.decrpt(encrypted, passphrase));
		Assert.assertEquals(password, plain);
	}
	
}
