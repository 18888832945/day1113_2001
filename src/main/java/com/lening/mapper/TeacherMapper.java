package com.lening.mapper;

import com.lening.entity.GradeBean;
import com.lening.entity.TestBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 创作时间：2020/11/6 9:26
 * 作者：李增强
 */
public interface TeacherMapper {
    List<TestBean> getDuliTestList(@Param("tid") Long tid);

    List<GradeBean> getGradeListByTid(@Param("tid") Long tid);

}
