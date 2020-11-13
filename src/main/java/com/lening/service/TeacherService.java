package com.lening.service;

import com.lening.entity.Exam;
import com.lening.entity.GradeBean;
import com.lening.entity.TestBean;

import java.util.List;

/**
 * 创作时间：2020/11/6 9:25
 * 作者：李增强
 */
public interface TeacherService {
    List<TestBean> getDuliTestList(Long tid);

    List<GradeBean> getGradeListByTid(Long tid);

    void saveTestMark(Long tid, List<Exam> list, TestBean testBean, Long[] gids);
}
