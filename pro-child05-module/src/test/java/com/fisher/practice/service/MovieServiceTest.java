package com.fisher.practice.service;

import com.fisher.practice.mvc.entry.mov.Movies;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * movieService层测试
 * @author fisher
 * @version 1.0.1 2023/6/14 - 16:02
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-mvc.xml")
public class MovieServiceTest {

    @Autowired
    @Qualifier(value = "druidDataSource")
    private DataSource dataSource;


    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MovieService movieService;

    private static Map<String ,Movies> movieMap;

    private static void init() {

        movieMap = new HashMap<>();

        String movieId = null;
        Movies movie = null;

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "肖申克救赎", 10.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "泰坦尼克号", 20.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "审死官", 30.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "大话西游之大圣娶亲", 40.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "大话西游之仙履奇缘", 50.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "功夫", 60.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "大内密探凌凌漆", 70.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "食神", 80.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "西游降魔篇", 90.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "西游伏妖篇", 11.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "三傻大闹宝莱坞", 12.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "唐人街探案", 13.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "一个人的武林", 14.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "罗马假日", 15.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "花季雨季", 16.0);
        movieMap.put(movieId, movie);

        movieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        movie = new Movies(movieId, "夏洛特烦恼", 17.0);
        movieMap.put(movieId, movie);
    }

    @Test
    public void testUUID(){
        String s = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        log.debug(s);
        log.debug(s.length()+"");
    }

    @Test
    public void testGetDruidDataSource(){
        log.debug(dataSource.toString());
    }

    @Test
    public void testSaveMovies(){
        init();
        for(Movies movies : movieMap.values()){
            String sql = "INSERT INTO fisher.t_movies(movie_id,movie_name,movie_price) VALUES (?,?,?)";
            jdbcTemplate.update(sql,movies.getMovieId(),movies.getMovieName(),movies.getMoviePrice());
        }
    }

    @Test
    public void testGetAllMovies(){
        List<Movies> allMovies = movieService.getAllMovies();
        for (Movies m : allMovies){
            log.debug(m.toString());
        }
    }
}