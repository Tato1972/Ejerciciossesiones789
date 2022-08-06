package com.example.Ejerciciossesiones789.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String hola(){
        return "Hola Bootcamp";
    }
}
