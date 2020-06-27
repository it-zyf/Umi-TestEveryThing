package com.example.xyy.test.sort;

/**
 * java 冒泡排序
 */

public class BubbleSort {

    public static void main(String[] args) {

        //冒泡排序算法
        int[] numbers = new int[]{1, 5, 8, 2, 3, 9, 4};

        BubbleSort.sort(numbers);


    }

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tem = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tem;
                }
            }

        }
        System.out.println("数组从小到大排序:");
        for (int i = 0; i < numbers.length; i++) {

            System.out.print(numbers[i]);
        }
    }



}
