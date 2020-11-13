package com.lening.controller;

import com.lening.comm.ResultInfo;
import com.lening.entity.*;
import com.lening.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创作时间：2020/11/4 11:02
 * 作者：李增强
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/deleteStudentBatch")
    public ResultInfo deleteStudentBatch(@RequestBody Long[] sids){
        try {
            userService.deleteStudentBatch(sids);
            return new ResultInfo(true, "删除成功");
        }catch (Exception e){
            return new ResultInfo(false, "删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("/findOne")
    public StudentBean findOne(Long sid){
        return userService.findOne(sid);
    }


    @RequestMapping("/saveStuInfo")
    @ResponseBody
    public ResultInfo saveStuInfo(@RequestBody StudentBean studentBean){
        try {
            userService.saveStuInfo(studentBean);
            return new ResultInfo(true, "更新成功");
        }catch (Exception e){
            return new ResultInfo(false,"更新失败");
        }
    }

    /**
     * 省市县三级联动
     */
    @ResponseBody
    @RequestMapping("/getCityListById")
    public List<CityBean> getCityListById(Long id){
        return userService.getCityListById(id);
    }

    /**
     * 查询班级列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGradeList")
    public List<GradeBean> getGradeList(){
        return userService.getGradeList();
    }

    @RequestMapping("/getStuAllList")
    @ResponseBody
    public List<StudentBean> getStuAllList(){

        return userService.getStuAllList();
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<UserBean> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/fileUpload")
    public void fileUpload(@RequestBody MultipartFile filename){

        try {
            /**
             * 从springMVC上传上来的文件中获取到输入流
             */
            InputStream inputStream = filename.getInputStream();
            /**
             * 创建一个excel，把流给他
             */
            /**
             * excel 2007的
             */
            SXSSFWorkbook xx = null;
            XSSFWorkbook yy = null;

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            /**
             * 获取工作簿里面的工作表，sheet，可以用名字来获取，也可以用角标来获取
             * 习惯性用角标来获取
             */
            HSSFSheet sheet = workbook.getSheetAt(0);
            /**
             * 开始遍历工作表里面的行，有需要知道有多少行
             */
            int num = sheet.getLastRowNum();
            List<Exam> list = new ArrayList<>();
            aa:for(int x=2;x<=num;x++){
                /**
                 * 使用角标获取excel工作表中的行，0和1不是试题
                 */
                HSSFRow row = sheet.getRow(x);
                Exam exam = new Exam();
                /**
                 * 获取行中第一列，题型
                 */
                HSSFCell cell = row.getCell(0);
                String value = cell.getStringCellValue();
                exam.setEtype(value);

                /**
                 * 题干
                 */

                String tigan = row.getCell(1).getStringCellValue();
                exam.setEname(tigan);
                /**
                 * 答案，答案和选项需要装进另外一个list里面去
                 * 答案拿到是一个
                 */
                String daan = row.getCell(2).getStringCellValue();


                /**
                 * 分值，装进去
                 */
                double fenzhi = row.getCell(3).getNumericCellValue();
                exam.setEfenzhi(fenzhi);

                /**
                 * 选项,开始判断，单选和多选有四个选项
                 * 判断题有两个选项，填空题和问答题，没有选项
                 */

                if("单选题".equals(value)){
                    String xxA = row.getCell(4).getStringCellValue();
                    String xxB = row.getCell(5).getStringCellValue();
                    String xxC = row.getCell(6).getStringCellValue();
                    String xxD = row.getCell(7).getStringCellValue();

                    ExamOption oA = new ExamOption();
                    oA.setOname(xxA);

                    ExamOption oB = new ExamOption();
                    oB.setOname(xxB);

                    ExamOption oC = new ExamOption();
                    oC.setOname(xxC);

                    ExamOption oD = new ExamOption();
                    oD.setOname(xxD);

                    /**
                     * 判断答案
                     */
                    if("A".equalsIgnoreCase(daan)){
                        oA.setIstrue(1);
                    }else if("B".equalsIgnoreCase(daan)){
                        oB.setIstrue(1);
                    }else if("C".equalsIgnoreCase(daan)){
                        oC.setIstrue(1);
                    }else if("D".equalsIgnoreCase(daan)){
                        oD.setIstrue(1);
                    }else{
                        System.out.println("题目有误");
                    }


                    exam.getOptions().add(oA);
                    exam.getOptions().add(oB);
                    exam.getOptions().add(oC);
                    exam.getOptions().add(oD);

                }else if("多选题".equals(value)){
                    String xxA = row.getCell(4).getStringCellValue();
                    String xxB = row.getCell(5).getStringCellValue();
                    String xxC = row.getCell(6).getStringCellValue();
                    String xxD = row.getCell(7).getStringCellValue();

                    ExamOption oA = new ExamOption();
                    oA.setOname(xxA);

                    ExamOption oB = new ExamOption();
                    oB.setOname(xxB);

                    ExamOption oC = new ExamOption();
                    oC.setOname(xxC);

                    ExamOption oD = new ExamOption();
                    oD.setOname(xxD);
                    /**
                     * 多选需要先把答案拿出来，进行分割
                     */

                    String[] split = daan.split("\\|");

                    List<String> daans = Arrays.asList(split);
                    if(daans.contains("A")){
                        oA.setIstrue(1);
                    }
                    if(daans.contains("B")){
                        oB.setIstrue(1);
                    }
                    if(daans.contains("C")){
                        oC.setIstrue(1);
                    }
                    if(daans.contains("D")){
                        oD.setIstrue(1);
                    }

                    exam.getOptions().add(oA);
                    exam.getOptions().add(oB);
                    exam.getOptions().add(oC);
                    exam.getOptions().add(oD);
                }

                else if("判断题".equals(value)){
                    String xxA = row.getCell(4).getStringCellValue();
                    String xxB = row.getCell(5).getStringCellValue();

                    ExamOption oA = new ExamOption();
                    oA.setOname(xxA);

                    ExamOption oB = new ExamOption();
                    oB.setOname(xxB);

                    if("A".equalsIgnoreCase(daan)){
                        oA.setIstrue(1);
                    }else if("B".equalsIgnoreCase(daan)){
                        oB.setIstrue(1);
                    }else{
                        System.out.println("题目有误");
                    }
                    exam.getOptions().add(oA);
                    exam.getOptions().add(oB);
                }

                list.add(exam);
            }
            System.out.println(1);
            System.out.println(list);

        }catch (Exception e){
            e.printStackTrace();
        }

    }




























}
