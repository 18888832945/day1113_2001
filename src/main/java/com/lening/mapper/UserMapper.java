package com.lening.mapper;

import com.lening.entity.CityBean;
import com.lening.entity.GradeBean;
import com.lening.entity.StudentBean;
import com.lening.entity.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 创作时间：2020/11/4 11:04
 * 作者：李增强
 */
public interface UserMapper {
    List<UserBean> getUserList();

    List<StudentBean> getStuAllList();

    List<GradeBean> getGradeList();

    List<CityBean> getCityListById(@Param("id") Long id);

    void saveStuInfo(StudentBean studentBean);

    void saveStudentGrade(@Param("sid") Long sid, @Param("gid") Long gid);

    StudentBean findOne(@Param("sid") Long sid);

    void deleteStudentBySid(@Param("sid") Long sid);

    void deleteStudentGrade(@Param("sid") Long sid);
}
