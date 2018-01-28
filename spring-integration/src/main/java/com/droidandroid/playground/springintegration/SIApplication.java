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

        for (int i=0;i<10;i++){
            Message<?> message = MessageBuilder.withPayload(i % 2 == 0 ? "Printing message payload for " + i : i)
                    .setHeader("messageNumber", i)
                    .build();
            System.out.println("Sending message "+i);
            printerGateway.print(message);
        }

    }
}