package com.example.xyy.test.stream;

import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yayu
 * @title: StreamTest2
 * @description: TODO
 * @date 2020/10/23 11:07
 */
public class StreamTest2 {
    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add("34");
        strings.add("56");
        strings.add("78");
        strings.add("0101201");


        SzdayyCdxxb szdayyCdxxb = new SzdayyCdxxb();
        szdayyCdxxb.setGrbh("12");
        szdayyCdxxb.setCdbh("xyy");
        SzdayyCdxxb szdayyCdxxb1 = new SzdayyCdxxb();
        szdayyCdxxb1.setGrbh("34");
        szdayyCdxxb1.setCdbh("xbb");

        SzdayyCdxxb szdayyCdxxb3 = new SzdayyCdxxb();
        szdayyCdxxb3.setGrbh("66");
        szdayyCdxxb3.setCdbh("sz");


        SzdayyCdxxb szdayyCdxxb4 = new SzdayyCdxxb();
        szdayyCdxxb4.setGrbh("0101201");
        szdayyCdxxb4.setCdbh("ey");


        ArrayList<SzdayyCdxxb> szdayyCdxxbs = new ArrayList<>();
        szdayyCdxxbs.add(szdayyCdxxb4);
        szdayyCdxxbs.add(szdayyCdxxb3);
        szdayyCdxxbs.add(szdayyCdxxb1);
        szdayyCdxxbs.add(szdayyCdxxb);

        List<SzdayyCdxxb> collect = szdayyCdxxbs.stream().filter(it -> !strings.contains(it.getGrbh())).collect(Collectors.toList());
        collect.forEach(a->{
            System.out.println(a);
        });

    }


}
