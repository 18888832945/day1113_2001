package com.lening.service.impl;

import com.lening.entity.CityBean;
import com.lening.entity.GradeBean;
import com.lening.entity.StudentBean;
import com.lening.entity.UserBean;
import com.lening.mapper.UserMapper;
import com.lening.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2020/11/4 11:03
 * 作者：李增强
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserBean> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<StudentBean> getStuAllList() {
        return userMapper.getStuAllList();
    }

    @Override
    public List<GradeBean> getGradeList() {
        return userMapper.getGradeList();
    }

    @Override
    public List<CityBean> getCityListById(Long id) {
        return userMapper.getCityListById(id);
    }

    @Override
    public void saveStuInfo(StudentBean studentBean) {
        if(studentBean!=null){
            if(studentBean.getSid()!=null){
                //修改
            }else{
                //新增
                userMapper.saveStuInfo(studentBean);
                userMapper.saveStudentGrade(studentBean.getSid(),studentBean.getGb().getGid());
            }
        }
    }

    @Override
    public StudentBean findOne(Long sid) {
        return userMapper.findOne(sid);
    }

    @Override
    public void deleteStudentBatch(Long[] sids) {
        if(sids!=null&&sids.length>=1){
            for (Long sid : sids) {
                userMapper.deleteStudentBySid(sid);
                userMapper.deleteStudentGrade(sid);
            }
        }
    }
}















