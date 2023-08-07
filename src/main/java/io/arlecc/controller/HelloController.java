package io.arlecc.controller;

import io.arlecc.service.HelloService;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello")
public class HelloController {

    private final HelloService helloService;
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    private final String language;

    public HelloController(HelloService helloService,
                           @Property(name= "hello.language") String language) {
        this.helloService = helloService;
        this.language = language;
    }

    @Get
    public String hello() {
        log.debug("calling hello...");
        return helloService.helloFromService();
    }

    @Get(uri="/language", produces = MediaType.TEXT_PLAIN)
    public String translation() {
        return language;
    }
}
