package com.fisher.practice.mvc.entry.mov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影实体类
 * @author fisher
 * @version 1.0.1 2023/6/14 - 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {

    private String movieId;
    private String movieName;
    private Double moviePrice;

}
