package com.mustang.netty;

import com.mustang.netty.utils.ApplicationContextTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner 1");
        log.info("======================================================================");
        log.info("启动配置profile：  "+ ApplicationContextTool.getActiveProfile());
        //log.info("数据库配置：  "+ ApplicationContextTool.getProperty("spring.datasource.url"));
        //log.info("redis配置：  "+ ApplicationContextTool.getProperty("spring.redis.host"));
        log.info("======================================================================");
    }
}
