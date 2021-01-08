package com.example.xyy.test;

public class TestHH {

    public static void main(String[] args) {
        int i = 10000000;
        String seqNum = String.format("%05d", i);
        System.out.println(seqNum);
    }

    public static String getSeqNumByLong(Long l, int bitCount) {
        String seqNum = String.format("%0" + bitCount + "d", l);
        return seqNum;
    }
}