package com.droidandroid.playground.springintegration.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;

public class CustomRouter extends AbstractMessageRouter{

    @Autowired @Qualifier("intChannel") private MessageChannel intChannel;
    @Autowired @Qualifier("strChannel") private MessageChannel strChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> targetChannels = new ArrayList<>();

        if(message.getPayload().getClass().equals(Integer.class)){
            targetChannels.add(intChannel);
        }else if(message.getPayload().getClass().equals(String.class)){
            targetChannels.add(strChannel);
        }

        return targetChannels;
    }
}
