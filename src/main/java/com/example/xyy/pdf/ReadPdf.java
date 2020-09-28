package com.example.xyy.pdf;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yayu
 * @title: ReadPdf
 * @description: TODO java读取pdf文件
 * @date 2020/9/249:18
 */
public class ReadPdf {
    public List<String> fileToList(File file) {
        String content = null;
        try {
            PDDocument document = PDDocument.load(file);
            // 获取页码
            int pages = document.getNumberOfPages();
            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            content = stripper.getText(document);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>(100);
        if (StringUtils.isNotEmpty(content)) {
            String[] lines = content.split("\n");
            return Arrays.asList(lines);
        }
        return list;
    }

    @Test
    public void test(){
        List<String> list = fileToList(new File("G:\\3d1f5b3d-aacc-42a6-bc20-ae289b0c86e7.pdf"));
        list.forEach(pdf->{
            if(pdf.trim()!=null){
                System.out.println(pdf);
            }
        });

    }



}
