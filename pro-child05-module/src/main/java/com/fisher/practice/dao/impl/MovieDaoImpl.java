package com.fisher.practice.dao.impl;

import com.fisher.practice.dao.MovieDao;
import com.fisher.practice.mvc.entry.mov.Movies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MovieDao 接口实现类
 * @author fisher
 * @version 1.0.1 2023/6/14 - 15:52
 */
@Slf4j
@Repository
public class MovieDaoImpl implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movies> getAllMovies() {
        String sql = "SELECT * FROM fisher.t_movies";
        RowMapper<Movies> mapper = new BeanPropertyRowMapper<>(Movies.class);
        try {
            return jdbcTemplate.query(sql, mapper);
        } catch (Exception e){
            log.debug("[MovieDaoImpl] getAllMovies Error");
        }
        return null;
    }

    @Override
    public Movies getMovieById(String movieId) {
        String sql = "SELECT * FROM fisher.t_movies WHERE movie_id = ?";
        RowMapper<Movies> mapper = new BeanPropertyRowMapper<>(Movies.class);
        try{
            return jdbcTemplate.queryForObject(sql,mapper,movieId);
        }catch (Exception e){
            log.debug("[MovieDaoImpl] getMoviesById Error");
        }
        return null;
    }

    @Override
    public void saveMovie(Movies movies) {
        String sql = "INSERT INTO fisher.t_movies(movie_id,movie_name,movie_price) VALUES (?,?,?)";
        jdbcTemplate.update(sql,movies.getMovieId(),movies.getMovieName(),movies.getMoviePrice());
    }

    @Override
    public void updateMovie(Movies movies) {
        String sql = "UPDATE fisher.t_movies SET movie_price = ? WHERE movie_id = ?";
        try{
            jdbcTemplate.update(sql, movies.getMoviePrice(), movies.getMovieId());
        }catch (Exception e){
            log.debug("[MovieDaoImpl] updateMovie Error");
        }
    }

    @Override
    public void removeMovie(Movies movies) {
        String sql = "DELETE FROM fisher.t_movies WHERE movie_id = ? AND movie_name = ?";
        try{
            jdbcTemplate.update(sql, movies.getMovieId(), movies.getMovieName());
        }catch (Exception e){
            log.debug("[MovieDaoImpl] removeMovie Error");
        }
    }
}
