package com.example.xyy.test.stream;
/**
 * Stream综合案例_使用Stream流
 * 现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
 * 1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中
 * 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中
 * 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中
 * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中
 * 5. 将两个队伍合并为一个队伍；存储到一个新集合中
 * 6. 根据姓名创建Person对象；存储到一个新集合中
 * 7. 打印整个队伍的Person对象信息。
 */

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.example.xyy.entity.User;
import com.example.xyy.test.threadPool.GetSum;
import com.google.common.primitives.Doubles;
import org.junit.Test;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        one.add("欧阳锋");

        //1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中
        //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中
        //把集合转换为Stream流
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);


        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
        //3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中
        //4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中
        //把集合转换为Stream流
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);

        //5. 将两个队伍合并为一个队伍；存储到一个新集合中
        //6. 根据姓名创建Person对象；存储到一个新集合中
        //7. 打印整个队伍的Person对象信息。
        //Stream.concat(oneStream,twoStream).map(name->new Person(name)).forEach(System.out::println);
        Stream.concat(oneStream, twoStream).map(Person::new).forEach(System.out::println);

    }

    //todo 肯定有更好的写法......
    @Test
    public void test() {
        AtomicReference<Double> a1 = new AtomicReference<>(0.0);
        AtomicReference<Double> b = new AtomicReference<>(0.0);
        AtomicReference<Double> c = new AtomicReference<>(0.0);
        AtomicReference<Double> d = new AtomicReference<>(0.0);
        ArrayList<User> users = new ArrayList<>();
        User user = new User("xyy", null, "男", "120");
        User user2 = new User("xyy", "18", "男", "66");
//        User user23 = new User("xyy", "十九", "男", "66");
//        users.add(user23);
        users.add(user2);
        users.add(user2);
        users.add(user);
        users.add(user);
        users.forEach(u -> {
            if (StrUtil.isNotEmpty(u.getAge())) {
                System.out.println(u.getAge());
            }
        });
        String s2 = users.stream().filter(u -> null != u).filter(u -> StrUtil.isNotEmpty(u.getAge())).filter(u -> NumberUtil.isNumber(u.getAge())).map(u -> Double.parseDouble(u.getAge())).reduce(Double::sum).get().toString();
        System.out.println(s2);

        users.stream().filter(u -> u != null).filter(s -> StrUtil.isNotBlank(s.getAge())).map(User::getAge).collect(Collectors.toList()).forEach(a -> {
            double v = Double.parseDouble(a);
            b.updateAndGet(v1 -> v1 + v);
        });
        System.out.println(b.toString());//36
        users.stream().filter(u -> u != null).filter(s -> StrUtil.isNotBlank(s.getSource())).map(User::getSource).collect(Collectors.toList()).forEach(a -> {
            double v = Double.parseDouble(a);
            a1.updateAndGet(v1 -> v1 + v);
        });
        System.out.println(a1.toString());//372

        String s1 = users.stream().filter(s -> s != null).filter(s -> StrUtil.isNotEmpty(s.getAge())).filter(s -> NumberUtil.isNumber(s.getAge())).map(s -> Double.parseDouble(s.getAge())).reduce(Double::sum).get().toString();
        System.out.println(s1);


        users.stream().filter(u -> u != null).filter(u -> StrUtil.isNotBlank(u.getAge())).forEach(u -> System.out.println(u));


    }

    //TODO filter过滤器留下过滤内容为true的.
    @Test
    public void test3() {
        User user = new User("xyy", null, "男", "120");
        User user2 = new User("xyy", "18", "男", "66");
        User user3 = new User("xyy", "十八", "男", "66");
        User user4 = new User("xyy", "20", "男", "66");
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        users.add(user);
        users.add(user4);
        String s = users.stream().filter(u -> null != u).filter(u -> StrUtil.isNotEmpty(u.getAge())).filter(u -> NumberUtil.isNumber(u.getAge())).map(u -> Double.parseDouble(u.getAge())).reduce(Double::sum).get().toString();
        System.out.println(s);
    }


    @Test
    public void test1() {
        boolean isBean = BeanUtil.isBean(User.class);
        System.out.println(isBean);
        User user = new User("张三", "19", "男", "100");
        HashMap<Object, Object> map = MapUtil.newHashMap();
        BeanUtil.copyProperties(user, map);

    }


}
