package com.example.xyy.leetCode;

/**
 * @author yayu
 * @title: Test1
 * @description: TODO 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @date 2020/8/614:21
 */
public class Test1 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3}, 3);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
         for (int j=i+1;j<nums.length;j++){
             if(nums[i]+nums[j]==target){
                 int[] a =new int[]{i,j};
                 return a;
             }
         }
        }
        return null;

    }

    public void test(){
        System.out.println("hahah");
    }
}
