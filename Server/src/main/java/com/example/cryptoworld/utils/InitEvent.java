package com.example.cryptoworld.utils;

import org.springframework.context.ApplicationEvent;

public class InitEvent extends ApplicationEvent {
    public InitEvent(Object source) {
        super(source);
    }
}
