/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                obstacleGrid[i][j] = -obstacleGrid[i][j];
            }
        }
        obstacleGrid[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]!=-1){
                    if(i>0 && obstacleGrid[i-1][j]!=-1){
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if(j>0 && obstacleGrid[i][j-1]!=-1){
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
// @lc code=end

