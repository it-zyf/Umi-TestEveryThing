package com.example.xyy.test.dlms;

/**
 * 单例模式 懒汉式
 */

public class God {
    private static God god;

    private God() {
    }

    public static God getInstance() {
        if (null == god) {
            god = new God();
        }
        return god;
    }

}
