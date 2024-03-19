package com.test.AccountSection.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tool {
    private Integer id;
    private  String name;
    private Integer price;
    private String qq;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer weight;
    private Integer view;
}
