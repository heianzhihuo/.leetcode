/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][][] dp = new double[n][n][k+1];
        for(int i=0;i<n;i++){
            int s = 0;
            for(int j=i;j<n;j++){
                s += nums[j];
                dp[i][j][1] = s*1.0/(j-i+1);
            }
        }
        for(int d=2;d<=k;d++){
            for(int i=0;i<n;i++){
                for(int j=i+d-1;j<n;j++){
                    dp[i][j][d] = 0;
                    for(int p=i;p<j;p++){
                        dp[i][j][d] = Math.max(dp[i][j][d],dp[i][p][1]+dp[p+1][j][d-1]);
                    }
                }
            }
        }

        return dp[0][n-1][k];
    }
}
// @lc code=end

