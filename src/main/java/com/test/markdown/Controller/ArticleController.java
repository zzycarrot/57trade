package com.test.markdown.Controller;


import com.test.markdown.POJO.PageBean;
import com.test.markdown.POJO.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.markdown.POJO.Article;
import com.test.markdown.Service.ArticleService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("article")
public class ArticleController  {
    /**
     * 服务对象
     */
    @Autowired
    private ArticleService articleService;

    @GetMapping("/selectAll")
    private Result list(@RequestParam(defaultValue = "1") Integer current,
                        @RequestParam(defaultValue = "10") Integer size){
        log.info("分页查询数据");
        Integer start = (current-1)*size;
        List<Article> articleList = articleService.list(start , size);
        Integer total = articleService.count();
        Integer pages = 1+(total-1)/size;
        PageBean pageBean = new PageBean(articleList,total,size,current,true,pages);
        return Result.Success(pageBean);
    }

    @GetMapping("/queryDetail")
    public Result selectOne(Integer id){
        log.info("根据id查询：{}",id);
        Article article = articleService.getById(id);
        return Result.Success(article);
    }

    @PostMapping("insert")
    public Result insert(@RequestBody Article article){
        log.info("插入文章：{}",article.getTitle());
        article.setCreateTime(LocalDateTime.now());
        articleService.insert(article);
        return Result.Success(true);
    }
    @PostMapping("update")
    public Result update(@RequestBody Article article){
        log.info("更新文章：id={}",article.getId());
        articleService.updateById(article);
        return Result.Success(true);
    }
    @PostMapping("deleteBatch")
    public  Result delete(@RequestBody List<Integer> idList){
        log.info("批量删除文章：id={}",idList);
        articleService.delete(idList);
        return Result.Success(true);
    }
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
//    @PostMapping("deleteBatch")
//    public Result delete(@RequestBody List<Long> idList) {
//        return Result.Success(this.articleService.removeByIds(idList));
//    }
}

