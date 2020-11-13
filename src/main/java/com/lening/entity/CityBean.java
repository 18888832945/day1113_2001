package com.lening.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创作时间：2020/11/10 14:51
 * 作者：李增强
 */
@Data
public class CityBean implements Serializable {
    private Long id;
    private Long pid;
    private String cname;
}
