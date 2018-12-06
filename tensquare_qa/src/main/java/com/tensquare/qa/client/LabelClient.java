package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * date: 2018/12/4 16:41
 * author: loveLy
 */
@FeignClient(value = "tensquare-base",fallback = LabelClientImpl.class)  //指定要调用的服务
public interface LabelClient {

    //指定微服务映射地址
    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
