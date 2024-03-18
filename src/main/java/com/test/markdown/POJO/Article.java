package com.test.markdown.POJO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Article)表实体类
 *
 * @author wang.xianlin
 * @since 2023-08-10 21:51:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    //主键ID
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}

