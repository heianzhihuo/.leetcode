/*
 * @lc app=leetcode.cn id=885 lang=java
 *
 * [885] 螺旋矩阵 III
 */

// @lc code=start
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int N = rows*cols;
        int[][] res = new int[N][2];
        int[][] dd = {{0,1},{1,0},{0,-1},{-1,0}};
        int k = 0,d = -1,j = 0;
        int x = rStart,y = cStart;
        res[k][0] = x;
        res[k][1] = y;
        k++;
        while(k<N){
            d = (d+1)%4;
            if(d==0 || d==2){
                j++;
            }
            for(int i=0;i<j;i++){
                x += dd[d][0];
                y += dd[d][1];
                if(x>=0 && x<rows && y>=0 && y<cols){
                    res[k][0] = x;
                    res[k][1] = y;
                    k++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

