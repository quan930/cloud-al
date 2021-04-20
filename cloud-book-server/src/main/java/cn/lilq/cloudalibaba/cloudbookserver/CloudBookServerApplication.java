package cn.lilq.cloudalibaba.cloudbookserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/18 15:56
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"cn.lilq.cloudalibaba.cloudbookserver.mapper"})
public class CloudBookServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudBookServerApplication.class, args);
    }
}
