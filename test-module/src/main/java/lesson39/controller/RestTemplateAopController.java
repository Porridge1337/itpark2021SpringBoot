package lesson39.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestTemplateAopController {

    private final RestTemplate restTemplate;


    @GetMapping("/allCities")
    public String getAllCities() {
        return restTemplate.getForObject(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("/allCities")
                .build(Map.of()), String.class);
    }

    @GetMapping("/city")
    public String getCity(String name) {
        return restTemplate.getForObject(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .queryParam("name", name)
                .path("/city")
                .build(Map.of()), String.class);
    }
}
