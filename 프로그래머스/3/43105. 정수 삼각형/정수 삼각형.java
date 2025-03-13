/*
2^500 까지
*/

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[500+1][500+1];
        
        dp[0][0] = triangle[0][0];
        
        // if (triangle.length <= 1) return dp[0][0];
        
        // dp[0][1] = triangle[0][1] + dp[0][0];
        // dp[1][1] = triangle[1][1] + dp[0][0];
        
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int num : dp[triangle.length-1]) {
            max = Math.max(max, num);
        }
        
        return max;
    }
}