package com.lening.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 创作时间：2020/11/5 10:51
 * 作者：李增强
 */
@Data
public class Exam implements Serializable {
    private Long examid;
    private String ename;
    private String etype;
    private Double efenzhi;
    private Long testid;
    private List<ExamOption> options = new ArrayList<ExamOption>();

}
