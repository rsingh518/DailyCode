class Solution {

    //https://leetcode.com/problems/minimum-path-sum/description/

    static int minPathSums(int i, int j, int[][] grid, int[][] dp) {
        // Base case-1
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        // Base case-2
        if (i < 0 || j < 0) {
            return 10000007;
        }
        // Memoization case
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Recur for the path in 0 to i-1
        int up = grid[i][j] + minPathSums(i-1, j, grid, dp);

        // Recur for the path in 0 to j-1
        int left = grid[i][j] + minPathSums(i, j-1, grid, dp);

        // Return the result
        return dp[i][j] = Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return minPathSums(n-1, m-1, grid, dp);
    }
}