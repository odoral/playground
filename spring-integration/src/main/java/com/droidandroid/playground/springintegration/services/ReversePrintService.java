package com.droidandroid.playground.springintegration.services;

public class ReversePrintService {

    public void reverse(String message) {
        System.out.println(new StringBuilder(message).reverse().toString());
    }
}
