package com.platzi_play.domain.repository;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.persistence.entity.MovieEntity;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id,UpdateMovieDto updateMovieDto);
    MovieDto delete(long id);
}
