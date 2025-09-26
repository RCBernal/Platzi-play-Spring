package com.platzi_play.domain.dto;

import com.platzi_play.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre gender,
        LocalDate releaseDate,
        Double rating,
        String state
) {
}


/*
Los Records en Spring Boot se usan para crear de forma concisa y sin código repetitivo clases de datos inmutables
y simples, como Objetos de Transferencia de Datos (DTOs) o configuraciones. Proporcionan automáticamente constructores,
métodos toString(), equals() y hashCode(), y campos finales, lo que reduce errores, mejora la legibilidad del código y
facilita el manejo de dato.

 ->Inmutabilidad: Una vez que un objeto Record se crea, sus valores no pueden ser modificados,
 lo que conduce a un código más seguro y predecible
 */