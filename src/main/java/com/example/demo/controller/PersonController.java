package com.example.demo.controller;


import com.example.demo.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "/people")
public class PersonController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    public PersonDto getPersonById() {
        return restTemplate.getForObject("http://localhost/****/people",PersonDto.class);
    }
}
