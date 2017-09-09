package com.f4k.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by pthanhtrung on 12/27/2016.
 */

@SpringBootApplication(scanBasePackages = "com.f4k")
@EnableJpaRepositories({"com.f4k.repository"})
@Import({SecurityConfig.class, AuthorizationServerConfig.class})
@EntityScan({"com.flyingsh4rk.domain", "com.flyingsh4rk.domain.nosql"})

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}