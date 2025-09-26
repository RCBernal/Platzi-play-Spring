package com.platzi_play.domain.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @PastOrPresent(message = "La feecha de lanzamiento debe ser anterior a la actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "El valor no puede ser menor a 0")
        @Max(value = 5, message = "El valor no debe ser mayor que 5")
        Double rating)
{
}


/*
Los Records en Spring Boot se usan para crear de forma concisa y sin código repetitivo clases de datos inmutables
y simples, como Objetos de Transferencia de Datos (DTOs) o configuraciones. Proporcionan automáticamente constructores,
métodos toString(), equals() y hashCode(), y campos finales, lo que reduce errores, mejora la legibilidad del código y
facilita el manejo de dato.

 ->Inmutabilidad: Una vez que un objeto Record se crea, sus valores no pueden ser modificados,
 lo que conduce a un código más seguro y predecible
 */