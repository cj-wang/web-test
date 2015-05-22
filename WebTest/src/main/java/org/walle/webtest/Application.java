package org.walle.webtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("file:config/config.xml")	//configuration file
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
