package com.lening.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创作时间：2020/11/5 10:55
 * 作者：李增强
 */
@Data
public class ExamOption implements Serializable {
    private Long optionid;
    private String oname;
    private Integer istrue=0;
    private Long examid;
}
