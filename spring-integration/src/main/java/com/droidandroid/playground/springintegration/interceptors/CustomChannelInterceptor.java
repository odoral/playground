package com.droidandroid.playground.springintegration.interceptors;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageBuilder;

public class CustomChannelInterceptor extends ChannelInterceptorAdapter{

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        return super.preSend(
                MessageBuilder.withPayload(message.getPayload().toString()+" Message intercepted.")
                        .copyHeaders(message.getHeaders())
                        .build(),
                channel);
    }
}
