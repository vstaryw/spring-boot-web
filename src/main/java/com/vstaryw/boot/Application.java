package com.vstaryw.boot;

import com.vstaryw.boot.properties.DBConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuw on 2016/10/13.
 */
@Configuration
@MapperScan("com.vstaryw.boot.mapper")
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties({DBConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
