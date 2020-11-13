package com.lening.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 创作时间：2020/11/10 13:48
 * 作者：李增强
 */
@Data
public class StudentBean implements Serializable {
    private Long sid;
    private String sname;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    private GradeBean gb = new GradeBean();
}
