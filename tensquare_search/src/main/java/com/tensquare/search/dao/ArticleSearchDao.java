package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Description:
 * date: 2018/11/29 9:34
 * author: loveLy
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 文章搜索. 模糊查询
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
