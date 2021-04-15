package com.smile.lc.medium;


public class 单词搜索 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(method_1(board, word));
    }

    /**
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     */
    //深度优先搜索
    public static boolean method_1(char[][] board, String word) {
        // 没有东西直接false
        if (board.length <= 0) {
            return false;
        }
        // 定义一个每个坐标是否被访问的标志
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 找到开头字母
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                if (check(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, boolean[][] visited, int i, int j, int k, String str) {
        // 如果现在找的这个字母，和单词这个位置上的不对应，false
        if (str.charAt(k) != board[i][j]) {
            return false;
        } else if (k == str.length() -1) {  // 如果对应，再判断是否是单词的最后一位，是的话就代表找到了
            return true;
        }
        // 标志这条路径上，这个坐标点已被使用
        visited[i][j] = true;
        // 定义方向：上下左右
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        //定义寻找结果标志
        boolean result = false;
        // 向该字母的上下左右四个方向搜索
        for (int[] dir : direction) {
            // 新坐标
            int newi = i + dir[0];
            int newj = j + dir[1];
            // 判断新坐标是否越界，越界了这个方向就不用找了
            if (0 <= newi && newi < board.length && 0 <= newj && newj <board[0].length) {
                // 判断这个新坐标是否在这条路径上已经被用过
                if (!visited[newi][newj]) {
                    // 查询这个方向上的新坐标是否满足要求
                    boolean flag = check(board, visited, newi, newj, k+1, str);
                    // 如果满足，就跳出本次方向寻找，继续向其他方向寻找，并返回true
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 将这条路径上被占用的点释放
        visited[i][j] = false;
        return result;
    }

}
