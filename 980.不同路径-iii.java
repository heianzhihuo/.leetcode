/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 */

// @lc code=start
class Solution {
    public int uniquePathsIII(int[][] grid) {
        count = 0;
        int m = grid.length,n = grid[0].length;
        int i,j,x=-1,y=-1;
        int left = 0;
        for(i=0;i<m;i++)
            for(j=0;j<n;j++)
                if(grid[i][j]==0)
                    left++;
                else if(grid[i][j]==1){
                    x=i;y=j;
                }
        grid[x][y] = 0;
        visit(grid,x,y,m,n,left+1);    
        return count;
    }
    
    int count;
    public void visit(int[][] grid,int x,int y,int m,int n,int left){
        if(x<0 || x>=m || y<0 || y>=n)
            return;
        if(grid[x][y]==2){
            if(left==0)
                count++;
            return;
        }
        if(left==0)
            return;
        if(grid[x][y]!=0)
            return;
        grid[x][y] = 3;
        left--;
        visit(grid,x-1,y,m,n,left);
        visit(grid,x+1,y,m,n,left);
        visit(grid,x,y-1,m,n,left);
        visit(grid,x,y+1,m,n,left);
        grid[x][y] = 0;
        left++;
    }
}
// @lc code=end

