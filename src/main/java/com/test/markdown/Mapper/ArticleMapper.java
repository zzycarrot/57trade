package com.test.markdown.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.test.markdown.POJO.Article;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface ArticleMapper {


    public List<Article> list(Integer start,Integer size);


    @Select("select count(*) from article")
    public Integer count();

    @Select("select * from article where id = #{id}")
    Article getById(Integer id);

    @Insert("INSERT into article (title, content, create_time) " +
            "VALUES (#{title},#{content},#{createTime})")
    void insert(Article article);

    @Update("UPDATE article set content=#{content},title = #{title} where id = #{id}")
    void updateById(Article article);

    void delete(List<Integer> idList);
}

