package io.arlecc.service;

import jakarta.inject.Singleton;

@Singleton
public class HelloServiceImpl implements HelloService{

    @Override
    public String helloFromService() {
        return "hello from HelloServiceImpl";
    }
}
