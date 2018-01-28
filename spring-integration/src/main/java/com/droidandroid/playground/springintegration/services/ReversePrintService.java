package com.droidandroid.playground.springintegration.services;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class ReversePrintService {

    public Message<String> reverse(Message<String> message) {
        System.out.println(message.getPayload());

        int messageNumber = (int) message.getHeaders().get("messageNumber");
        return MessageBuilder.withPayload("Sending reply for message " + messageNumber).build();
    }
}
