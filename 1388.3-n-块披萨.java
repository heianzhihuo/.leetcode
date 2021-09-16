/*
 * @lc app=leetcode.cn id=1388 lang=java
 *
 * [1388] 3n 块披萨
 */

// @lc code=start
class Solution {

    public int maxSizeSlices(int[] slices) {
        int m = slices.length;
        int n = m/3;
        int[][] dp = new int[m][n];
        for(int i=0;i<m-2;i++){
            dp[i][0] = Math.max(slices[i],slices[i+1]);
            dp[i][0] = Math.max(dp[i][0],slices[i+2]);
        }

        dp[m-2][0] = Math.max(slices[m-2],slices[m-1]);
        dp[m-2][0] = Math.max(dp[m-2][0],slices[0]);

        dp[m-1][0] = Math.max(slices[m-1],slices[0]);
        dp[m-1][0] = Math.max(dp[m-1][0],slices[1]);
        for(int k=1;k<n;k++){
            for(int i=0;i<m;i++){
                dp[i][k] = 0;
                for(int j=0;j<k;j++){
                    for(int a=0;a<3*k+3;a++){
                        int xx = dp[(i+a)%m][j] + dp[(i+a+j*3+3)%m][k-j-1];
                        dp[i][k] = Math.max(dp[i][k],xx);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+",");
            }
        }
        return dp[0][n-1];
    }
}
// @lc code=end

