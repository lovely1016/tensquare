package com.tensquare.friend.service;

import com.tensquare.friend.client.UserClient;
import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * date: 2018/12/4 17:23
 * author: loveLy
 */
@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    @Autowired
    private UserClient userClient;

    //删除好友
    @Transactional
    public void deleteFriend(String userid,String friendid){
        friendDao.deleteFriend(userid,friendid);
        friendDao.updateLike(friendid,userid,"0");//将对方的互粉状态设置为单向喜欢
        addNoFriend(userid,friendid);//向不喜欢列表中添加

        //减少关注数和粉丝数
        userClient.incFollowcount(userid,-1);
        userClient.incFanscount(friendid,-1);
    }


    //不喜欢列表中添加记录
    public void addNoFriend(String userid,String friendid){
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }

    //喜欢列表中添加记录
    @Transactional
    public int addFriend(String userid,String friendid){
        //如果用户已经添加了这个好友,则不进行任何操作,返回0
        if (friendDao.selectCount(userid,friendid)>0) {
            return 0;
        }

        //向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);

        //判断对方是否喜欢你,将对方作为用户,自己作为好友
        if (friendDao.selectCount(friendid,userid)>0) {
            //同时更新两个人好友表的数据
            friendDao.updateLike(userid,friendid,"1");
            friendDao.updateLike(friendid,userid,"1");
        }

        //添加粉丝数和关注数
        userClient.incFanscount(userid,1);
        userClient.incFollowcount(friendid,1);
        return 1;
    }
}
