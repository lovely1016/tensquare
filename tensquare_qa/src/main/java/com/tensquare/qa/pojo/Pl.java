package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Description:
 * date: 2018/11/27 10:38
 * author: loveLy
 */
@Entity
@Table(name="tb_pl")
public class Pl implements Serializable {

    @Id
    private String problemid;

    @Id
    private String lableid;

    public String getLableid() {
        return lableid;
    }
    public void setLableid(String lableid) {
        this.lableid = lableid;
    }
    public String getProblemid() {
        return problemid;
    }
    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }
}
