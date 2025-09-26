package com.platzi_play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatziPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziPlayApplication.class, args);
	}

}

//Inyeccion de dependencias (SI)  es un patron de diseño, permite pasarle a una clase los objetos que esta necesita
/*
Como funciona el Spring IOC containes

 @Repository
 ->Acceso a datos

 @Service
 ->Logica de negocio

 @Controller o @RestController
 ->Exposicion web

 @Component
 ->Componente generico
 */

/*
El patron de dise;o Data maper nos ayuda a seprar el modelo de dominio de la forma en que los datos estan representados en nuestra API
 */