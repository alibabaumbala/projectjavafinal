package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.WebsocketClientSpec;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Configurable
@Service
public class API{
//    @Bean
    public List<Object> webclient(String uri)
    {
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(result);
    }

}
