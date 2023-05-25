package com.example.demo;

import com.example.demo.config.ProfileManager;
import com.example.demo.config.env.EnvConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Jpa Auditing 기능 실행
public class DemoApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    public DemoApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
        LOGGER.info(envConfiguration.getMessage());
        profileManager.printActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
