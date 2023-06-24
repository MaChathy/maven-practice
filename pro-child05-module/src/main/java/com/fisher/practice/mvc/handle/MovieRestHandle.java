package com.fisher.practice.mvc.handle;

import com.fisher.practice.mvc.entry.mov.Movies;
import com.fisher.practice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * 实现REST-ful 的CRUD
 * @author fisher
 * @version 1.0.1 2023/6/15 - 16:49
 */
@Slf4j
@Controller
public class MovieRestHandle {

    private final MovieService movieService;

    public MovieRestHandle(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * 处理首页超链接请求
     * @param model model
     * @return 电影列表视图名
     */
    @RequestMapping("/movie")
    public String showMovieList(Model model){

        List<Movies> allMovies = movieService.getAllMovies();

        model.addAttribute("allMovies", allMovies);

        return "movie-rest-list";
    }

    /**
     * 删除指定电影id
     * @param movieId 电影id
     * @return 电影列表视图名(重定向)
     */
    @RequestMapping(value = "/movie/{movieId}",method = RequestMethod.DELETE)
    public String removeMovieById(
            @PathVariable("movieId") String movieId){

        Movies movies = new Movies();
        movies.setMovieId(movieId);
        movieService.removeMovie(movies);

        return "redirect:/movie";
    }

    /**
     * 添加电影信息
     * @param movieName 电影名
     * @param moviePrice 电影票价
     * @return 电影列表视图名(重定向)
     */
    @RequestMapping(value = "/movie",method = RequestMethod.PUT)
    public String addMovie(
            @RequestParam("movieName") String movieName,
            @RequestParam("moviePrice") Double moviePrice){

        String id = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT);
        Movies movies = new Movies(id,movieName,moviePrice);

        movieService.saveMovie(movies);

        return "redirect:/movie";
    }

    /**
     * 修改电影信息
     * @param movieId 电影id
     * @param model model
     * @return 编辑电信信息视图名
     */
    @RequestMapping(value = "/movie/{movieId}",method = RequestMethod.GET)
    public String editMovieInfo(
            @PathVariable("movieId") String movieId,
            Model model){

        Movies movieById = movieService.getMovieById(movieId);
        model.addAttribute("movieById",movieById);

        return "movie-rest-edit";
    }

    /**
     * 保存修改后的电影信息
     * @param movieId 电影id
     * @param movieName 电影名
     * @param moviePrice 电影票价
     * @return 电影列表视图名(重定向)
     */
    @RequestMapping(value = "/movieUpdate",method = RequestMethod.PUT)
    public String saveEditMovie(
            @RequestParam("movieId") String movieId,
            @RequestParam("movieName") String movieName,
            @RequestParam("moviePrice") Double moviePrice){

        Movies movies = new Movies(movieId,movieName,moviePrice);

        movieService.updateMovie(movies);

        return "redirect:/movie";
    }
}
