package com.test.Bar.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tool {
    private Integer id;
    private String name;
    private String reward;
    private Integer price;
    private String time;
    private String qq;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer weight;
    private Integer view;
}
