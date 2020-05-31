package com.xinli.xinli;

import com.xinli.xinli.websocket.NewWebsocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class XinliApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(XinliApplication.class, args);
        //注入 websocket 容器
        //解决自动注入问题
        NewWebsocket.setApplicationContext(run);
    }

}