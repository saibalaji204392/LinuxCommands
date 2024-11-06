package org.example.corejava;

public class SmallestMissingInteger {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 1, 3, 4};
        System.out.println(findSmallestMissing(arr1));
        System.out.println(findSmallestMissing(arr2));
    }

    public static int findSmallestMissing(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return n;
    }
}
