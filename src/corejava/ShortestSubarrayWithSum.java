package corejava;

public class ShortestSubarrayWithSum {public static void main(String[] args) {
    int[] arr1 = {2, 4, 6, 10, 2, 1};
    int K1 = 12;
    System.out.println(shortestSubarray(arr1, K1));

    int[] arr2 = {5, 8, 50, 4};
    int K2 = 50;
    System.out.println(shortestSubarray(arr2, K2));
}

    public static int shortestSubarray(int[] arr, int K) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum == K) {
                    minLength = Math.min(minLength, end - start + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
