package io.arlecc.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class HelloControllerTest {

    @Inject
    @Client("/hello")
    HttpClient httpClient;

    @Test
    public void doitRetournerMessageDeBienvenueQuandJappelleHello()
    {
        var response = httpClient.toBlocking().retrieve("");

        assertEquals("hello from HelloServiceImpl", response);
    }

    @Test
    public void doitRetournerBonStatutQuandJappelleHello()
    {
        var response = httpClient.toBlocking().exchange("");

        assertEquals(HttpStatus.OK, response.getStatus());
    }
}
