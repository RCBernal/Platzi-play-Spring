package com.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        if (estado==null) return null;
        return switch (estado) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("booleantoString")
    public static String booleantoString(Boolean state){
        return state == null ? null : (state ? "D" : "N");

    }
}
