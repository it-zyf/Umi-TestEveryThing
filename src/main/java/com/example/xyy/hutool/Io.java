package com.example.xyy.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yayu
 * @title: Io
 * @description: TODO
 * @date 2020/8/1210:08
 */
@RestController
@RequestMapping("/io")
public class Io {
    int arr[] = new int[10];

    //todo 导入...
    @Test
    public void test() {
        ExcelReader reader = ExcelUtil.getReader("E:/123.xlsx");
        List<List<Object>> readAll = reader.read();
        for (List<Object> objects : readAll) {
            System.out.println(objects);
        }
    }


    // todo 导出.
    @RequestMapping("/test")
    public void test2(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setAge("9");
        user.setName("张三");
        User user2 = new User();
        user2.setAge("19");
        user2.setName("张三3");
        User user3 = new User();
        user3.setAge("190");
        user3.setName("张三33");
        List<User> rows = CollUtil.newArrayList(user, user2, user3);
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(rows, true);
        //自定义标题
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=log.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    //TODO 读取文件.
    @Test
    public void test3() {
        FileReader fileReader = new FileReader("F:\\game.txt");
        FileWriter writer = new FileWriter("E:\\game.txt");
        List<String> list = fileReader.readLines();
        writer.writeLines(list);
    }

    public void test4(){
        FileWriter writer = new FileWriter("test.properties");
        writer.write("test");
    }


}
