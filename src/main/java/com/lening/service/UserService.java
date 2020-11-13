package com.lening.service;

import com.lening.entity.CityBean;
import com.lening.entity.GradeBean;
import com.lening.entity.StudentBean;
import com.lening.entity.UserBean;

import java.util.List;

/**
 * 创作时间：2020/11/4 11:03
 * 作者：李增强
 */
public interface UserService {
    List<UserBean> getUserList();

    List<StudentBean> getStuAllList();

    List<GradeBean> getGradeList();

    List<CityBean> getCityListById(Long id);

    void saveStuInfo(StudentBean studentBean);

    StudentBean findOne(Long sid);

    void deleteStudentBatch(Long[] sids);
}
