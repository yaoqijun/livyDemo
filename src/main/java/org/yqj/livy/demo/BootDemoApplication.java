package org.yqj.livy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@SpringBootApplication
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
        new SpringApplicationBuilder()
                .banner(new DemoBanner())
                .sources(BootDemoApplication.class)
                .run(args);
    }
}
