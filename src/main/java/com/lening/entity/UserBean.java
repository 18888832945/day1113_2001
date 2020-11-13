package com.lening.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 创作时间：2020/11/4 10:59
 * 作者：李增强
 */
@Data
public class UserBean implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer age;

}
