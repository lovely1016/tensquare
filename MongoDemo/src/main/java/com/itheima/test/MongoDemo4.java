package com.itheima.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2018/11/27 20:08
 * author: loveLy
 */
public class MongoDemo4 {

    //插入数据
    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("192.168.211.130");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        Map<String,Object> map = new HashMap<>();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        //添加数据到documemnt对象中
        Document document = new Document(map);

        //执行添加
        spit.insertOne(document);
        //关闭连接
        client.close();
    }
}
