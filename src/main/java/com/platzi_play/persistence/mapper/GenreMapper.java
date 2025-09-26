package com.platzi_play.persistence.mapper;

import com.platzi_play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genero) {
      //  return Genre.valueOf(genero.toUpperCase()); toUUperCase sirve para convertir un texto a mayúsculas.
        if (genero == null) return null;

        return switch (genero.toUpperCase()){
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATED;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("generateToString")
    public static String generateToString(Genre genre) {
        if (genre == null) return null;
        return switch (genre){
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "HORROR";
            case SCI_FI -> "CIENCIA_FICCION";
        };
    }
}
