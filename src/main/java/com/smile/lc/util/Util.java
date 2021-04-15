package com.smile.lc.util;

import java.util.Scanner;

/**
 * @author Smile
 * @version 3.0
 * @date 2020-10-4 13:42
 */
public class Util {
    public static void swap(int arr[],int index,int index2){
        int i = arr[index];
        arr[index]=arr[index2];
        arr[index2]=i;
    }
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public static int in(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }

    public static int[] getRandomArr(int length, int min, int max) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (min + Math.random() * (max - min + 1));
        }
        return a;
    }
}
