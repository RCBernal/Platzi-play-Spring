package com.platzi_play.domain.service;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

//para contenedor de inversion de control
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //deuelve todas las peliculas
    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getall(){
        return this.movieRepository.getAll();
    }

    public MovieDto getbyid(Long id){
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto){
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id, updateMovieDto);
    }

    public MovieDto delete(long id){
        return this.movieRepository.delete(id);
    }
}
