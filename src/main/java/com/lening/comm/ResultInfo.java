package com.lening.comm;

import lombok.Data;

import java.io.Serializable;

/**
 * 创作时间：2020/11/6 14:39
 * 作者：李增强
 */
@Data
public class ResultInfo implements Serializable {
    private boolean flag;
    private String msg;

    public ResultInfo() {
    }

    public ResultInfo(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
