package com.pay.activetools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ActivetoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivetoolsApplication.class, args);
    }
}
