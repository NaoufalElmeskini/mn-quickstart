package io.arlecc.controller;

import io.arlecc.service.HelloService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @Get
    public String hello() {
        return "hello world!";
    }
}
