package com.lening.service.impl;

import com.lening.entity.Exam;
import com.lening.entity.ExamOption;
import com.lening.entity.GradeBean;
import com.lening.entity.TestBean;
import com.lening.mapper.TeacherMapper;
import com.lening.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2020/11/6 9:25
 * 作者：李增强
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<TestBean> getDuliTestList(Long tid) {
        return teacherMapper.getDuliTestList(tid);
    }

    @Override
    public List<GradeBean> getGradeListByTid(Long tid) {
        return teacherMapper.getGradeListByTid(tid);
    }

    @Override
    public void saveTestMark(Long tid, List<Exam> list, TestBean testBean, Long[] gids) {
        /**
         * 先去把老师的名字查出来
         */
        /**
         * 先去保存考试信息，然后要把testid拿回来
         */
        Long testid=0l;

        /**
         * 先保存试题或者先保存   考试和班级的关联关系
         */
        /**
         * 先保存班级和考试信息  tb_test_grade
         * 在这里遍历或者把数组传进xml在遍历
         */

        /**
         * 保存试题
         */
        for (Exam exam : list) {
            exam.setTestid(testid);
            //去保存试题，然后拿回试题id  tb_exam
            List<ExamOption> options = exam.getOptions();
            //判断这个试题有没有选项，有的话，保存试题的选项
            for (ExamOption option : options) {
                option.setExamid(exam.getExamid());
                //再去保存   tb_examoption
            }
        }

    }
}
