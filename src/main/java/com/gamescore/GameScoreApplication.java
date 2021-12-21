package com.gamescore;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GameScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameScoreApplication.class, args);
    }

}
