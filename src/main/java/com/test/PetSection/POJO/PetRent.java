package com.test.PetSection.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRent {
    private Integer id;
    private  String name;
    private Integer weekPrice;
    private Integer monthPrice;
    private Integer deposit;
    private String qq;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer weight;
    private Integer view;
}
