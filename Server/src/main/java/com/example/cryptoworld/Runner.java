package com.example.cryptoworld;

import com.example.cryptoworld.utils.initEvent;
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
        initEvent initEvent=new initEvent(this);
        applicationEventPublisher.publishEvent(initEvent);
    }
}
