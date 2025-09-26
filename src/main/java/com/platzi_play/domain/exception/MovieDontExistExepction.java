package com.platzi_play.domain.exception;

public class MovieDontExistExepction extends RuntimeException {
    public MovieDontExistExepction(Long id) {
        super("Movie with id : " + id + " dont exists");
    }
}
