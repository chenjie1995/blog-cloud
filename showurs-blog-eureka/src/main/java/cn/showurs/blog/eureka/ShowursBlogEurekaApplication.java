package cn.showurs.blog.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShowursBlogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowursBlogEurekaApplication.class, args);
    }
}
