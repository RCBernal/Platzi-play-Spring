package com.platzi_play.web.controller;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.SuggestRequestDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.domain.service.MovieService;
import com.platzi_play.domain.service.PlatziPlayAIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name="Movies ", description = "Operations about movies of Platziplay")
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayAIService aiService;

    public MovieController(MovieService movieService, PlatziPlayAIService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        List<MovieDto> list =this.movieService.getall();
        if(list==null || list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(this.movieService.getall());
      //return this.movieService.getall();
    }

    @GetMapping("/{id}")
    @Operation(summary="Serch by ID ",
            description = "Serch by ID movies of Platziplay",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "400",description = "Pelicula no encontrada",content = @Content)

    })
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicula a recuperar",example = "1") @PathVariable Long id){ //Metodo que retorne una sola movieDTO
        MovieDto movieDto=this.movieService.getbyid(id);
        if(movieDto==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(movieDto);
                //this.movieService.getbyid(id);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
        return  ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreference()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
         return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id,updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable long id){
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.movieService.delete(id));
    }

}
//Con ResponseEntity podemos controlar y perzonalizar las repuestas del API