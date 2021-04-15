package com.smile.lc.medium;

import java.util.*;

public class 单词拆分 {

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] strings = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

        List<String> list = Arrays.asList(strings);
        System.out.println(method_2(list, word));
        System.out.println(new Date().getTime());
    }

    // 字符串太長的話就算不出來了
    public static boolean method_1(List<String> wordList, String word) {
        if (wordList == null || wordList.size() <= 0 || word == null || "".equals(word)) {
            return false;
        }
        return check(wordList, word);
    }

    public static boolean check(List<String> wordList, String word) {

        boolean result = false;
        for (String w : wordList) {
            if (word.length() >= w.length() && w.equals(word.substring(0, w.length()))) {
                String newWord = word.substring(w.length());
                if ("".equals(newWord)) {
                    return true;
                }
                boolean flag = check(wordList, newWord);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean method_2 (List<String> wordList, String word) {
        Set<String> wordSet = new HashSet<>(wordList);

        boolean dp[] = new boolean[word.length() + 1];
        dp[0] = true;
        // 從第一個字符開始切割
        for (int i = 1; i <= word.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static boolean method_2_2 (List<String> wordList, String word) {
        Set<String> wordSet = new HashSet<>();
        int max = 0;
        boolean dp[] = new boolean[word.length() + 1];
        for (String s : wordList) {
            wordSet.add(s);
            max = Math.max(max, s.length());
        }
        dp[0] = true;
        // 從第一個字符開始切割
        for (int i = 1; i <= word.length(); i ++) {
            for (int j = i; j >= 0 && j >= i - max; j --) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
