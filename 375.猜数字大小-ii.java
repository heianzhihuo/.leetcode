/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n;i++){
            dp[i][i+1] = i;
        }
        for(int d=2;d<=n-1;d++){
            for(int i=1;i+d<=n;i++){
                int j = i+d;
                dp[i][j] = Math.min(i+dp[i+1][j],j+dp[i][j-1]);
                for(int k=i+1;k<=j-1;k++){
                    dp[i][j] = Math.min(dp[i][j],k+Math.max(dp[i][k-1],dp[k+1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
// @lc code=end

