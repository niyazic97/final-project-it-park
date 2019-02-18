package ru.itpark.service;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import ru.itpark.dto.FilmsDto;
import ru.itpark.entity.FilmsType;

@Service
public class FilmApiService {


    public static final String API_KEY = "6b1fae4f6f7786c0c208272e81af6595";

    public Movie exactFilm(Integer id) {
        // Create an instance of the service you wish to use
// you should re-use these
        Tmdb tmdb = new Tmdb(API_KEY);
        MoviesService moviesService = tmdb.moviesService();
// Call any of the available endpoints
        try {
            Response<Movie> response = moviesService
                    .summary(id, "ru-RU")
                    .execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (Exception e) {
            // see execute() javadoc
        }
        return null;
    }

    public FilmsDto convertToFilmDto(Movie movie) {
        FilmsDto filmsDto = new FilmsDto();
        filmsDto.setGenre(FilmsType.valueOf(movie.genres.stream().findFirst().get().name.toUpperCase()));
        filmsDto.setName(movie.title);
        filmsDto.setPlot(movie.overview);
        filmsDto.setWorldPremier(movie.release_date);
        return filmsDto;
    }

    public FilmsDto getFilmDtoById(Integer id) {
        Movie movie = exactFilm(id);
        if (movie != null) {
            return convertToFilmDto(movie);
        }
        return null;
    }

}
