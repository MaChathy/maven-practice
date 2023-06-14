package com.fisher.practice.mvc.handle;

import com.fisher.practice.mvc.entry.mov.Movies;
import com.fisher.practice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

/**
 * MovieController
 * @author fisher
 * @version 1.0.1 2023/6/14 - 17:22
 */
@Slf4j
@Controller
public class MovieHandle {

    private final MovieService movieService;

    public MovieHandle(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/show/list")
    public String showAllMovie(HttpSession session){

        List<Movies> allMovies = movieService.getAllMovies();
        session.setAttribute("allMovies", allMovies);

        return "movie-list";
    }

    @RequestMapping(value = "/remove/movie")
    public String removeMovie(
            @RequestParam(value = "movieId") String movieId){

        Movies movies = new Movies();
        movies.setMovieId(movieId);
        movieService.removeMovie(movies);

        return "redirect:/show/list";
    }

    @RequestMapping("/save/movie")
    public String saveMovie(
            @RequestParam(value = "movieName") String movieName,
            @RequestParam(value = "moviePrice") Double moviePrice){
        String movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        Movies movies = new Movies(movieId,movieName,moviePrice);

        movieService.saveMovie(movies);

        return "redirect:/show/list";
    }

    @RequestMapping("/update/movie/page")
    public String updateMovie(
            @RequestParam(value = "movieId") String movieId,
            Model model) {

        Movies movieById = movieService.getMovieById(movieId);

        model.addAttribute("movieById", movieById);

        return "movie-update";
    }

    @RequestMapping("/saveUpdate/movie")
    public String saveUpdate(
            @RequestParam(value = "movieID") String movieId,
            @RequestParam(value = "movieName") String movieName,
            @RequestParam(value = "moviePrice") Double moviePrice){

        log.debug("movieId : " + movieId);
        Movies movies = new Movies(movieId,movieName,moviePrice);

        movieService.updateMovie(movies);

        return "redirect:/show/list";
    }

}
