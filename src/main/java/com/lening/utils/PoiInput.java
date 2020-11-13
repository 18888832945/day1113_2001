package com.lening.utils;

import com.lening.entity.Exam;
import com.lening.entity.ExamOption;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创作时间：2020/11/6 14:41
 * 作者：李增强
 */
public class PoiInput {
    public static List getTestList(MultipartFile filename){
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
                }else{
                    System.out.println("改类型的题目不支持");
                }

                list.add(exam);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
