package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * date: 2018/11/26 16:03
 * author: loveLy
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
@RefreshScope
public class UserController {

    @Autowired
    private LabelService labelService;

    @Value("${sms.ip}")
    private String ip;


    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public String ip() {
        return ip;
    }

    //查询全部列表
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        //int s = 1/0;
        return new Result(true,StatusCode.OK,"查询成功",labelService.findAll());
    }

    //根据ID查询标签
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        System.out.println("No.1");
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
    }

    //增加标签
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    //修改标签
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Label label,@PathVariable String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    //删除标签
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  Result deleteById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    //条件查询
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap){
        List<Label> labelList = labelService.findSearch(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",labelList);
    }

    //条件+分页查询
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap,@PathVariable int page,@PathVariable int size){
        Page<Label> pageList = labelService.findSearch(searchMap,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageList.getTotalElements(),pageList.getContent()));
    }

}
