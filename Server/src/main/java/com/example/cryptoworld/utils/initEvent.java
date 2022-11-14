package com.example.cryptoworld.utils;

import org.springframework.context.ApplicationEvent;

public class initEvent extends ApplicationEvent {
    public initEvent(Object source) {
        super(source);
    }
}
