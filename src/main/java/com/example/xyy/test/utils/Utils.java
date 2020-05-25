package com.example.xyy.test.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * 获取txt文件内容并按行放入list中
     **/
    public static List<String> getFileContext() throws Exception {
        FileReader fileReader = new FileReader("D:\\666.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.trim().length() > 2) {
                list.add(str);
            }
        }
        return list;
    }
}
