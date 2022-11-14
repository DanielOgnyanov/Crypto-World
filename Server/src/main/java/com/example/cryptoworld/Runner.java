package com.example.cryptoworld;

import com.example.cryptoworld.utils.InitEvent;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    private ApplicationEventPublisher applicationEventPublisher;

    public Runner(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InitEvent initEvent=new InitEvent(this);
        applicationEventPublisher.publishEvent(initEvent);
    }
}
