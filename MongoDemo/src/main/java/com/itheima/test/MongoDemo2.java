package com.itheima.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Description:
 * date: 2018/11/27 20:08
 * author: loveLy
 */
public class MongoDemo2 {

    //条件查询
    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("192.168.211.130");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //构建查询条件
        BasicDBObject bson = new BasicDBObject("userid","1013");
        //查询记录获取文档集合
        FindIterable<Document> documents = spit.find(bson);
        //遍历数据
        for (Document document : documents) {
            System.out.println("内容:"+document.getString("content"));
            System.out.println("用户ID:"+document.getString("userid"));
            System.out.println("浏览量:"+document.getInteger("visits"));
            System.out.println("======================");
        }
        //关闭连接
        client.close();
    }
}
