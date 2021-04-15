package com.smile.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    public static void main(String[] args) {
        String s = "16.0";
        System.out.println(Integer.parseInt(s.substring(0, s.length() -2)));
        int[] nums = new int[] {1,2,3};
        method_1(nums);
    }

    public static List<List<Integer>> method_1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        // 总共有2的n次方个子集
        int n = nums.length;
        if (n == 0) {
            return result;
        }
        String s = String.valueOf(Math.pow(2, n));
        int l = Integer.parseInt(s.substring(0, s.length() - 2));
        for (int i = 0; i < l; i++) {
            String s1 = Integer.toUnsignedString(i, 2);
            String format = String.format("%0" + n + "d", Integer.parseInt(s1));
            String[] split = format.split("");
            List<Integer> subResult = new ArrayList<>();
            for (int j = 0; j < split.length; j ++) {
                int seat = Integer.valueOf(split[j], 10);
                if (seat == 1) {
                    subResult.add(nums[j]);
                }
            }
            result.add(subResult);
        }
        return result;
    }

    //method_2位运算
    public static List<List<Integer>> method_2(int[] nums) {
        int n = nums.length;
        //创建临时列表
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 用 mask 把 nums里的每一个元素是否加入了集合标注出来
        // 每个元素加入集合就是1，没有加入就是0
        // 所以总共有 2的n次方种组合，假设nums = [1,2,3,4]，mask = 0000到1111，总共32种，即子集的数量是 2的n次方
        // 每一种mask都是一个子集
        for (int mask = 0; mask < 1<<n; mask ++) {
            // 清除上一次保存的元素
            t.clear();
            // 从第一位开始检查
            for(int i = 0; i < n; i ++) {
                // 如果 这个元素加入集合了，那么其在mask上的标志将会被置1，如集合{1，2}，mask = 1100
                // 对i进行移位后与mask相与找到每个mask上的被置1的位置对应nums上的元素，并加入到t中
                if ((mask & (1<<i)) != 0) {
                    t.add(nums[i]);
                }
            }
            //对一个mask遍历完了，mask代表的子集t就可加入到result中
            result.add(new ArrayList<>(t));
        }
        return result;
    }
}
