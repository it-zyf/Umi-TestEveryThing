package com.example.xyy.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonToOrcWriterTest {

    public void write(Class<?> tClass, File inputFile, String orcPath) throws IOException {
        final List<Field> fields = new ArrayList<>();
        if (null != tClass.getSuperclass()) {
            fields.addAll(Arrays.asList(tClass.getSuperclass().getDeclaredFields()));
        }
        fields.addAll(Arrays.asList(tClass.getDeclaredFields()));
        for (Field field : fields) {
            final String name = field.getName();
           final String humpToLine = CamelCaseKit.humpToLine(name);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            final JSONObject object = JSON.parseObject(reader.readLine());
            JSONObject jsonObject = JSONObject.parseObject(CamelCaseKit.humpToLine(object.toString()));
            if(!jsonObject.containsKey(humpToLine)) System.out.println(humpToLine);
            }
        }

}
