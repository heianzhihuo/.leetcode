/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 */

// @lc code=start
class Solution {

    int[][] grid;
    public void DFS(int x,int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length){
            return;
        }
        if(grid[x][y]==1){
            grid[x][y] = 2;
            DFS(x+1,y);
            DFS(x-1,y);
            DFS(x,y+1);
            DFS(x,y-1);
        }
    }

    public int shortestBridge(int[][] grid) {
        int res = grid.length+grid[0].length;
        this.grid = grid;
        label1:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    DFS(i,j);
                    break label1;
                }
            }
        }
        List<List<Integer>> s1 = new ArrayList<>();
        List<List<Integer>> s2 = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    s1.add(Arrays.asList(i,j));
                }else if(grid[i][j]==2){
                    s2.add(Arrays.asList(i,j));
                }
            }
        }
        for(int i=0;i<s1.size();i++){
            for(int j=0;j<s2.size();j++){
                int d = Math.abs(s1.get(i).get(0)-s2.get(j).get(0))
                +Math.abs(s1.get(i).get(1)-s2.get(j).get(1));
                res = Math.min(d-1,res);
            }
        }
        return res;
    }
}
// @lc code=end

