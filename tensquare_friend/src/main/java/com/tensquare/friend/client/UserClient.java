package com.tensquare.friend.client;

/**
 * Description:
 * date: 2018/12/4 20:14
 * author: loveLy
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户客户端
 */
@FeignClient("tensquare-user")
public interface UserClient {

    //增加粉丝数
    @RequestMapping(value = "/user/incfans/{userid}/{x}",method = RequestMethod.POST)
    public void incFanscount(@PathVariable("userid")String userid,@PathVariable("x")int x);

    //增加关注数
    @RequestMapping(value="/user/incfollow/{userid}/{x}",method= RequestMethod.POST)
    public void incFollowcount(@PathVariable("userid") String userid,@PathVariable("x") int x);
}
