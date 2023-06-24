package com.fisher.practice.service.impl;

import com.fisher.practice.dao.MovieDao;
import com.fisher.practice.mvc.entry.mov.Movies;
import com.fisher.practice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MovieService 接口实现类
 * @author fisher
 * @version 1.0.1 2023/6/14 - 15:40
 */
@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movies> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public Movies getMovieById(String movieId) {
        return movieDao.getMovieById(movieId);
    }

    @Override
    public void saveMovie(Movies movies) {
        movieDao.saveMovie(movies);
    }

    @Override
    public void updateMovie(Movies movies) {
        movieDao.updateMovie(movies);
    }

    @Override
    public void removeMovie(Movies movies) {
        movieDao.removeMovie(movies);
    }
}
