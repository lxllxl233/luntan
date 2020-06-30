package com.woqiyounai.luntan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuntanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuntanApplication.class, args);
        //new SpringApplicationBuilder().sources(LuntanApplication.class).run(args);
    }

}
