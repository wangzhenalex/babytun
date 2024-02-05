package com.example.babytun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.example.babytun")//mybatis在springboot启动时候自动扫描mybatis实现的接口
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)//开启spring session的redis支持
public class BabytunApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytunApplication.class, args);
    }

}
