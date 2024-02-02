package org.example.babytunseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("org.example.babytunseckill")
@EnableScheduling //启用任务调度功能
public class BabytunSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytunSeckillApplication.class, args);
    }

}
