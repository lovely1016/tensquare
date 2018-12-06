package com.tensquare.friend.controller;

import com.netflix.discovery.converters.Auto;
import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * date: 2018/12/4 17:36
 * author: loveLy
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;


    //删除好友
    @RequestMapping(value = "/{friendid}",method = RequestMethod.DELETE)
    public Result remove(@PathVariable String friendid){
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims==null) {
            return new Result(false,StatusCode.ACCESSERROR,"无权访问");
        }
        friendService.deleteFriend(claims.getId(),friendid);
        return new Result(true,StatusCode.OK,"删除成功");
    }


    /**
     * 添加好友
     * @param friendid
     * @param type
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type){
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims==null) {
            return new Result(false,StatusCode.ACCESSERROR,"无权访问");
        }

        //如果是喜欢
        if (type.equals("1")) {
            if (friendService.addFriend(claims.getId(), friendid) == 0) {
                return new Result(false, StatusCode.REPERROR, "已经添加此好友");
            }
        } else {
            //不喜欢
            friendService.addNoFriend(claims.getId(),friendid);//添加不喜欢的列表
        }
        return new Result(true,StatusCode.OK,"操作成功");
    }
}
