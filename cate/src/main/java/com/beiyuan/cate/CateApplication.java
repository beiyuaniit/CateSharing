package com.beiyuan.cate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: beiyuan
 * @date: 2022/12/3  9:10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CateApplication.class, args);
    }

}
