package com.example.xyy.test;//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.hive.ql.exec.vector.*;
//import org.apache.orc.OrcFile;
//import org.apache.orc.TypeDescription;
//import org.apache.orc.Writer;


import com.example.xyy.test.bean.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TmpTest {

    @Autowired
    private ServerBuyGoods serverBuyGoods;


    public static void main(String[] args) throws Exception {
        String Start = "D:\\";
        List<String> list1 = TmpTest.getFileContext2();
        List<String> list = TmpTest.getFileContext();
        int y = 0;
        for (String s : list) {
            File file = new File(Start+s);
            System.out.println(list1.get(y)+"===>"+"表中缺少字段:");
            String name = list1.get(y);
//            System.out.println(getclass(name));
            new JsonToOrcWriterTest().write(getclass(name), file, "D:\\");
            y++;
        }


    }

    public static Class getclass(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException// className是类名
    {
        Class obj = Class.forName(className); // 以String类型的className实例化类
        return obj;
    }


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


    /**
     * 获取txt文件内容并按行放入list中
     **/
    public static List<String> getFileContext2() throws Exception {
        FileReader fileReader = new FileReader("D:\\data.txt");
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




