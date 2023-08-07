package io.arlecc.controller;

import io.arlecc.service.HelloService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello")
public class HelloController {

    private final HelloService helloService;
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @Get
    public String hello() {
        log.debug("calling hello...");
        return helloService.helloFromService();
    }
}
