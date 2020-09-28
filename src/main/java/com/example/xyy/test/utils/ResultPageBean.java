package com.example.xyy.test.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页返回数据.
 */
@Data
public class ResultPageBean {
    private String status;
    private Integer total;
    private List<?> data;

    public static ResultPageBean ok(String status, Integer total, List<?> data) {
        return new ResultPageBean(status, total, data);
    }

    private ResultPageBean(String status, Integer total, List<?> data) {
        this.status = status;
        this.total = total;
        this.data = data;
    }

}
