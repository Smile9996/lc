package com.smile.lc.hard;

public class 接雨水 {
    public static void main(String[] args) {
        System.out.println(method_1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(method_2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int method_1(int[] h) {
        if (h.length <= 2) {
            return 0;
        }
        int result = 0;
        // 两端肯定不会有水，所以i的取值范围为 1 到 h.length - 2
        for (int i = 1; i < h.length - 1; ++ i) {
            //找出该列左边最长的
            int max_left = 0;
            for (int l = i - 1; l >= 0; -- l) {
                if (max_left < h[l]) {
                    max_left = h[l];
                }
            }
            //找出该列右边最长的
            int max_right = 0;
            for (int r = i + 1; r < h.length; ++ r) {
                if (max_right < h[r]) {
                    max_right = h[r];
                }
            }

            //去两个边的最小值（短板效应）
            int minEdge = Math.min(max_left, max_right);
            //那最小值减去该列的值，就是该列所积的水(注意要判断是否能积水）
            if (minEdge > h[i]) {
                result += minEdge - h[i];
            }
        }
        return result;
    }

    // 方法1的优化，不用每次遍历去找该节点的左边的最高的墙和右边的最高的墙
    public static int method_2(int[] h) {
        int[] max_left = new int[h.length];
        int[] max_right = new int[h.length];
        //找出每一列的左边最高的墙
        //找出每一列的右边最高的墙
        for (int i = 1; i < h.length; i ++ ) {
            max_left[i] = Math.max(max_left[i-1], h[i-1]);
            max_right[h.length - 1 -i] = Math.max(max_right[h.length - i], h[h.length -i]);
        }

        //找出每一列的右边最高的墙
//        for (int j = h.length - 2; j >= 0; j --) {
//            max_right[j] = Math.max(max_right[j+1], h[j + 1]);
//        }
        int minEdge = 0;
        int result = 0;
        for (int i = 1; i < h.length - 1; i ++) {
            minEdge = Math.min(max_left[i], max_right[i]);
            if (minEdge > h[i]) {
                result += minEdge - h[i];
            }
        }
        return result;
    }
}
