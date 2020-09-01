package com.example.xyy.test.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yayu
 * @title: Crawler
 * @description: TODO 这是一个爬虫程序,用来找图片... 只能默认下载30张图片...
 * @date 2020/8/617:02
 */
@SuppressWarnings("all")
public class Crawler {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎体验这个小程序！");
        while (true) {
            System.out.println("请输入您要下载图片明星的姓名(输入E\\e退出)：");
            String name = input.next();
            if ("e".equals(name) || "E".equals(name)) {
                break;
            }
            System.out.println("正在下载，请稍等……");
            downBeautyPicture(name);
            System.out.println();
        }
        System.out.println("成功退出，欢迎下次光临！");
    }

    public static void downBeautyPicture(String name) {
        String targetPath = "P://"+"crawler//" + name + System.currentTimeMillis();
        new File(targetPath).mkdir();
        int count = 0;

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://image.baidu.com/search/index?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-8&word=" + name);
            is = url.openStream();

            int len;
            byte[] buffer = new byte[1024];
            StringBuilder pageText_ = new StringBuilder();
            while ((len = is.read(buffer)) != -1) {
                pageText_.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }

            String pageText = pageText_.toString();
            Pattern compile = Pattern.compile("https://.*?0\\.jpg");
            Matcher matcher = compile.matcher(pageText);
            ArrayList<String> URLs = new ArrayList<>();

            while (matcher.find()) {
                String eachURLStr = matcher.group();

                if (URLs.contains(eachURLStr)) {
                    continue;
                }

                count++;
                //System.out.println("正在下载第"+ count +"张图片…………");
                URL eachURL = new URL(eachURLStr);
                is = eachURL.openStream();
                fos = new FileOutputStream(targetPath + "\\" + System.currentTimeMillis() + ".jpg");
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                is.close();
                fos.flush();
                fos.close();
                URLs.add(eachURLStr);
            }
        } catch (IOException e) {
            System.out.println("对不起，下载错误，请重试");
            e.printStackTrace();
        } finally {
            System.out.println("下载完成，共下载了" + count + "图片，请到  " + targetPath + "  目录下查看");
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
