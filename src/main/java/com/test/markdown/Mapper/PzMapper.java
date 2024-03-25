package com.test.markdown.Mapper;

import com.test.markdown.POJO.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PzMapper {

    @Select("select id,title,create_time from pz order by create_time DESC  limit #{start},#{size}")
    public List<Article> list(Integer start,Integer size);

    @Select("SELECT COUNT(*) from pz")
    public Integer count();

    @Select("select * from pz where id = #{id}")
    Article getById(Integer id);

    @Insert("INSERT into pz (title, content, create_time) " +
            "VALUES (#{title},#{content},#{createTime})")
    void insert(Article pz);

    @Update("UPDATE pz set content=#{content},title = #{title} where id = #{id}")
    void updateById(Article pz);

    void delete(List<Integer> idList);
}

