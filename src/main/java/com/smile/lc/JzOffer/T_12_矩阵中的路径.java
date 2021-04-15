package com.smile.lc.JzOffer;

import java.util.HashSet;
import java.util.Set;

public class T_12_矩阵中的路径 {

    public static void main(String[] args) {
    }

    public static boolean find(String target, char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (target.charAt(0) == board[i][j]) {
                    if (check(board, visited, i, j, 0, target)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, boolean[][] visited, int i, int j, int k, String target) {
        if (board[i][j] != target.charAt(k)) {
            return false;
        }else if (k == target.length() -1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : direction) {
            int newi = i + dir[0], newj = j + dir[1];
            if (0 <= newi && newi < board.length && 0 <= newj && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    if(check(board, visited, newi, newj, k + 1, target)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
