package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * Description:
 * date: 2018/11/29 9:32
 * author: loveLy
 */
@Document(indexName = "tensquare",type = "article")
public class Article implements Serializable {

    @Id
    private String id;//ID

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index= true ,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文

    private String state;//审核状态


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
