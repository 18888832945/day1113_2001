package com.lening.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创作时间：2020/11/4 14:45
 * 作者：李增强
 */
@Data
public class MenuBean implements Serializable {
    private Long mid;
    private String mname;
    private Long pid;
    private String url;
    private String target;
    private String icon;

}
