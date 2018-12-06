package com.tensquare.friend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Description:
 * date: 2018/12/4 17:14
 * author: loveLy
 */
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)  //联合主键加上
public class Friend implements Serializable {

    @Id
    private String userid;
    @Id
    private String friendid;

    private String islike;


    public String getIslike() {
        return islike;
    }

    public void setIslike(String islike) {
        this.islike = islike;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }
}
