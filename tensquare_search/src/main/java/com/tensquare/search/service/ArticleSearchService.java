package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Description:
 * date: 2018/11/29 9:35
 * author: loveLy
 */
@Service
public class ArticleSearchService {


    @Autowired
    private ArticleSearchDao articleSearchDao;


    //文章搜索
    public Page<Article> findByTitleLike(String keywords,int page,int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,pageRequest);
    }

    //增加文章
    public void add(Article article){
        articleSearchDao.save(article);
    }
}
