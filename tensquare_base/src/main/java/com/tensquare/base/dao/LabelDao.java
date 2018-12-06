package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Description:
 * date: 2018/11/26 15:55
 * author: loveLy
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {
}
