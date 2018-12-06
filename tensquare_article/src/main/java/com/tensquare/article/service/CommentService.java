package com.tensquare.article.service;

import com.tensquare.article.dao.CommentDao;
import com.tensquare.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * Description:
 * date: 2018/11/28 11:48
 * author: loveLy
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;



    //根据文章ID查询评论列表
    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }

    //文章评论新增
    public void add(Comment comment){
        comment.set_id(idWorker.nextId()+"");
        commentDao.save(comment);
    }
}
