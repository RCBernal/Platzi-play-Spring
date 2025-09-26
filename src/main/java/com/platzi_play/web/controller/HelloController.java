package com.platzi_play.web.controller;

import com.platzi_play.domain.service.PlatziPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que es un control de peticiones que vayamos a recibir dentro de la aplicacion
public class HelloController {

    private final String plataform;
    private final PlatziPlayAIService aiService;

    public HelloController(@Value("${spring.application.name}") String plataform, PlatziPlayAIService aiService) {
        this.plataform = plataform;
        this.aiService = aiService;
    }

    @GetMapping("/hello") //Nos sirve para obtener informacion
    public String Hello() {
        return this.aiService.generateGreeting(plataform);
    }
}


