package com.droidandroid.playground.springintegration;

import com.droidandroid.playground.springintegration.gateways.PrinterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SIApplication implements ApplicationRunner{

    @Autowired private PrinterGateway printerGateway;

    public static void main(String [] args){
        SpringApplication.run(SIApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Future<Message<String>>> futures = new ArrayList<>();

        for (int i=0;i<10;i++){
            Message<String> message = MessageBuilder.withPayload("Printing message payload for " + i)
                    .setHeader("messageNumber", i)
                    .build();
            System.out.println("Sending message "+i);
            futures.add(printerGateway.print(message));
        }

        futures.forEach(f -> {
            try {
                System.out.println(f.get().getPayload());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}