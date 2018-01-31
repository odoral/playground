package com.droidandroid.playground.springintegration.splitters;

import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSplitter2{
    public List<String> split(Message<?> message) {
        return new ArrayList<>(Arrays.asList(message.getPayload().toString().split("a")));
    }
}
