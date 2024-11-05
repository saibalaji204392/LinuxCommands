package corejava;

public class MaximumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };
        System.out.println(maxPathSum(matrix));
    }

    public static int maxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxAbove = dp[i - 1][j];
                if (j > 0) maxAbove = Math.max(maxAbove, dp[i - 1][j - 1]);
                if (j < n - 1) maxAbove = Math.max(maxAbove, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j] + maxAbove;
            }
        }

        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[m - 1][j]);
        }

        return maxSum;
    }
}
