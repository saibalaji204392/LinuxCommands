package org.example.corejava;

import java.util.HashSet;
import java.util.Set;

public class LoopLengthFinder {
    public static void main(String[] args) {
        int[] arr = {2, -1, 1, 2, 2};
        System.out.println(findLoopLength(arr));
    }

    public static int findLoopLength(int[] arr) {
        int n = arr.length;
        Set<Integer> visited = new HashSet<>();
        int currentIndex = 0;

        while (true) {
            if (visited.contains(currentIndex)) {
                return calculateLoopLength(arr, currentIndex);
            }
            if (currentIndex < 0 || currentIndex >= n) {
                return -1;
            }
            visited.add(currentIndex);
            currentIndex = (currentIndex + arr[currentIndex] + n) % n;
        }
    }

    private static int calculateLoopLength(int[] arr, int start) {
        int length = 0;
        int currentIndex = start;
        do {
            currentIndex = (currentIndex + arr[currentIndex] + arr.length) % arr.length;
            length++;
        } while (currentIndex != start);
        return length;
    }
}
