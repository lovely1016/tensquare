package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * date: 2018/11/28 9:30
 * author: loveLy
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;


    //点赞
    public void updateThumbup(String id){
        /*Spit spit = spitDao.findById(id).get();
        spit.setThumbup(spit.getThumbup()+1);
        spitDao.save(spit);*/

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup",1);//使某个字段的值+1
        mongoTemplate.updateFirst(query,update,"spit");
    }

    //根据上级ID查询吐槽列表
    public Page<Spit> findByParentid(String parentid,int page,int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid,pageRequest);
    }

    //查询全部记录
    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    //根据id查询实体
    public Spit findById(String id){
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    //增加吐槽
    public void add(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        spit.setPublishtime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setState("1");
        //如果存在上级ID,则为评论
        if (spit.getParentid()!=null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"spit");
        }
        spitDao.save(spit);
    }

    //修改
    public void update(Spit spit){
        spitDao.save(spit);
    }

    //删除
    public void deleteById(String id){
        spitDao.deleteById(id);
    }
}
