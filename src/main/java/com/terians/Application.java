package com.terians;

import com.terians.config.Neo4JConfig;
import com.terians.config.SwaggerConfig;
import com.terians.config.WebAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        Neo4JConfig.class, WebAppConfig.class, SwaggerConfig.class
})
public class Application {

    // Tell Spring to launch our app!
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}