package com.lening.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创作时间：2020/11/5 10:58
 * 作者：李增强
 */
@Data
public class TestBean implements Serializable {
    private Long testid;
    private String testname;
    private String totalscore;
    private String passscore;
    private Integer testtime;

    private Date starttime;

    private Date endtime;

    private Date updatetime = new Date();
    private Long authorid;
    private String testauthor;
}
