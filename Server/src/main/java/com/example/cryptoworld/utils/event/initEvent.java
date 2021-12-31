package com.example.cryptoworld.utils.event;

import org.springframework.context.ApplicationEvent;

public class initEvent extends ApplicationEvent {
    public initEvent(Object source) {
        super(source);
    }
}
