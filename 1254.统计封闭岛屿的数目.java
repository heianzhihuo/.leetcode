/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 *
 * https://leetcode-cn.com/problems/number-of-closed-islands/description/
 *
 * algorithms
 * Medium (59.85%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 24.9K
 * Testcase Example:  '[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]'
 *
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 
 * 请返回封闭岛屿的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * ⁠            [1,1,1,1,1,1,1]]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        int z = 2;
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    boolean ret = DFS(grid,m,n,z,i,j);
                    z++;
                    if(ret) cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean DFS(int[][] grid,int m,int n,int z,int x,int y){
        if(x==-1 || x==m || y==-1 || y==n) return false;
        if(grid[x][y]!=0) return true;// visited
        grid[x][y] = z;
        boolean ret = true;
        ret = DFS(grid,m,n,z,x-1,y) && ret;
        ret =  DFS(grid,m,n,z,x+1,y) && ret;
        ret = DFS(grid,m,n,z,x,y-1) && ret;
        ret = DFS(grid,m,n,z,x,y+1) && ret;
        return ret;
    }
}
// @lc code=end

