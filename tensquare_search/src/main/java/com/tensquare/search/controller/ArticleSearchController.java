package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * date: 2018/11/29 9:37
 * author: loveLy
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;


    //文章搜索
    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(articlePage.getTotalElements(),articlePage.getContent()));
    }


    //添加文章
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true,StatusCode.OK,"操作成功");
    }
}
