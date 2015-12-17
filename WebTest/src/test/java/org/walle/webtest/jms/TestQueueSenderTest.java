package org.walle.webtest.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.walle.webtest.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestQueueSenderTest {

	@Autowired
	private TestQueueSender testQueueSender;
	
	@Test
	public void testSend() {
		testQueueSender.send("haha, msg from jms sender. 1");
		testQueueSender.send("haha, msg from jms sender. 2");
		testQueueSender.send("haha, msg from jms sender. 3");
		testQueueSender.send("haha, msg from jms sender. 4");
		testQueueSender.send("haha, msg from jms sender. 5");
		testQueueSender.send("haha, msg from jms sender. 6");
		testQueueSender.send("haha, msg from jms sender. 7");
		testQueueSender.send("haha, msg from jms sender. 8");
		testQueueSender.send("haha, msg from jms sender. 9");
	}
	
}
