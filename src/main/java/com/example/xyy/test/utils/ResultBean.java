package com.example.xyy.test.utils;

/**
 * 返回数据封装.
 */
public class ResultBean {
    private String status;
    private String msg;
    private Object obj;

    public static ResultBean build() {
        return new ResultBean();
    }

    public static ResultBean ok(String msg) {
        return new ResultBean("200", msg, null);
    }

    public static ResultBean ok(String msg, Object obj) {
        return new ResultBean("200", msg, obj);
    }

    public static ResultBean error(String msg) {
        return new ResultBean("500", msg, null);
    }

    public static ResultBean error(String msg, Object obj) {
        return new ResultBean("500", msg, obj);
    }

    private ResultBean() {
    }

    private ResultBean(String status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public String getStatus() {
        return status;
    }

    public ResultBean setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public ResultBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
