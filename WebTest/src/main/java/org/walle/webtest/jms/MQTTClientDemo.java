package org.walle.webtest.jms;

import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.Listener;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

public class MQTTClientDemo {

	public static void main(String[] args) throws Exception {
		MQTT mqtt = new MQTT();
		mqtt.setHost("tcp://localhost:1883");
		
		//To be able to receive off line messages
		//use fixed client id and set cleanSession to false
		mqtt.setClientId("client_2323");
		mqtt.setCleanSession(false);
		
		final CallbackConnection connection = mqtt.callbackConnection();
		
		connection.listener(new Listener() {
		    public void onConnected() {
		    	System.out.println("Connected");
		    }
		    public void onDisconnected() {
		    	System.out.println("Disconnected");
		    }

		    public void onPublish(UTF8Buffer topic, Buffer payload, Runnable ack) {
		        // You can now process a received message from a topic.
		    	String topicString = UTF8Buffer.decode(topic);
		    	String payloadString = UTF8Buffer.decode(Buffer.utf8(payload));
		    	System.out.println("Message from " + topicString + ": " + payloadString);
		    	// Once process execute the ack runnable.
		        ack.run();
		    }
		    
		    public void onFailure(Throwable value) {
//		        connection.close(null); // a connection failure occured.
		    	value.printStackTrace();
		    }
		});
		
		connection.connect(new Callback<Void>() {
		    // Once we connect..
		    public void onSuccess(Void v) {
		        // Subscribe to a topic
		        Topic[] topics = {new Topic("TestTopic", QoS.EXACTLY_ONCE)};
		        connection.subscribe(topics, new Callback<byte[]>() {
		            public void onSuccess(byte[] qoses) {
		                // The result of the subcribe request.
				    	System.out.println("Subscribe success");
		            }
		            public void onFailure(Throwable value) {
//		                connection.close(null); // subscribe failed.
		            	value.printStackTrace();
		            }
		        });

//		        // Send a message to a topic
//		        connection.publish("foo.bar", "Hello".getBytes(), QoS.EXACTLY_ONCE, false, new Callback<Void>() {
//		            public void onSuccess(Void v) {
//		            	// the pubish operation completed successfully.
//				    	System.out.println("on publish success");
//		            }
//		            public void onFailure(Throwable value) {
////		                connection.close(null); // publish failed.
//		            	value.printStackTrace();
//		            }
//		        });
//
//		        // To disconnect..
//		        connection.disconnect(new Callback<Void>() {
//		            public void onSuccess(Void v) {
//		            	// called once the connection is disconnected.
//				    	System.out.println("on disconnect success");
//		            }
//		            public void onFailure(Throwable value) {
//		            	// Disconnects never fail.
//		            	value.printStackTrace();
//		            }
//		        });
		    }
		    public void onFailure(Throwable value) {
//		        result.failure(value); // If we could not connect to the server.
		    	value.printStackTrace();
		    }
		});
		
		//cj: have to keep the application alive
		Thread.sleep(Integer.MAX_VALUE);
		
	}
	
}
