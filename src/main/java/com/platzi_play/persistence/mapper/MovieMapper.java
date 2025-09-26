package com.platzi_play.persistence.mapper;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel ="spring",uses = {GenreMapper.class,StateMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo",target = "title")
    @Mapping(source = "duracion",target = "duration")
    @Mapping(source = "genero",target = "gender",qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno",target = "releaseDate")
    @Mapping(source = "calificacion",target = "rating")
    @Mapping(source = "estado",target = "state",qualifiedByName = "stringToBoolean")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDtos(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration //anotacion para traer de reversa los Mapping
    @Mapping(source ="gender",target ="genero",qualifiedByName = "generateToString")
    MovieEntity toEntity(MovieDto dto);

    @Mapping(target = "titulo",source = "title")
    @Mapping(target = "fechaEstreno",source = "releaseDate")
    @Mapping(target = "calificacion",source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto,@MappingTarget MovieEntity movieEntity);
}
