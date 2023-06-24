package com.fisher.practice.service;

import com.fisher.practice.mvc.entry.mov.Movies;

import java.util.List;

/**
 * MovieService接口
 * <br> 包括基本CRUD功能
 * @author fisher
 * @version 1.0.1 2023/6/14 - 15:39
 */
public interface MovieService {

    /**
     * 获取电影列表
     * @return 电影list
     */
    List<Movies> getAllMovies();

    /**
     * 查询指定id的电影
     * @param movieId 电影id
     * @return movies实体类
     */
    Movies getMovieById(String movieId);

    /**
     * 添加功能
     * @param movies Movies实体类
     */
    void saveMovie(Movies movies);

    /**
     * 更新电影信息
     * @param movies Movies实体类
     */
    void updateMovie(Movies movies);

    /**
     * 删除电影
     * @param movies Movies实体类
     */
    void removeMovie(Movies movies);
}
