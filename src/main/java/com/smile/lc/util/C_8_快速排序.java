package com.smile.lc.util;

public class C_8_快速排序 {

    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10,0,20);
        Util.print(arr);
        quickSort(arr,0,arr.length-1);
        Util.print(arr);
    }

    public static void quickSort(int[] A,int p,int r){
        if (p<r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static int partition(int[] A,int p,int r){
        int pivot = A[p];
        int sp = p+1;
        int bigger = r;
        while (sp <= bigger){
            if (A[sp]<=pivot){
                sp++;
            }else {
                Util.swap(A,sp,bigger);
                bigger--;
            }
        }
        Util.swap(A,p,bigger);
        return bigger;
    }
}
