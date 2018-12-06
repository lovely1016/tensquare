package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * date: 2018/12/4 19:37
 * author: loveLy
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {

    //不喜欢列表数据
}
