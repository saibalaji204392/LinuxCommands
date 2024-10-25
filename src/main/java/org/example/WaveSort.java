package org.example;
import java.util.*;

public class WaveSort {
        public static int[] sortInWaveFormat(int[] arr, int n)
        {
            for (int i=0; i<n; i++) {
                if(i%2 == 0) {
                    if(i<n-1 && arr[i] <= arr[i+1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }else{
                    if(i<n-1 && arr[i] >= arr[i+1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
          return arr;
        }
        public static void main(String[] args)
        {
            int[] arr = {10, 90, 49, 2, 1, 5, 23};
            int n = arr.length;
            int[] ar = sortInWaveFormat(arr, n);
            for (int i : ar)
                System.out.print(i + " ");
        }
    }
