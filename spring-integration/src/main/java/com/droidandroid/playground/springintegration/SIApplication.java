package com.droidandroid.playground.springintegration;

import com.droidandroid.playground.springintegration.gateways.CustomGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SIApplication implements ApplicationRunner{

    @Autowired private CustomGateway customGateway;

    public static void main(String [] args){
        SpringApplication.run(SIApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        customGateway.print("Hello world!!");
    }
}