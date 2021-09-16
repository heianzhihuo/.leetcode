/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 */

// @lc code=start
class Solution {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        int n = blocked.length;
        List<List<Integer>> cur;
        int[][] grid;
        int xx,yy;

        grid = new int[n*2+1][n*2+1];
        xx = source[0];
        yy = source[1];
        for(int i=0;i<blocked.length;i++){
            int x = blocked[i][0]+n-xx;
            int y = blocked[i][1]+n-yy;
            if(x>=0 && x<=n*2 && y>=0 && y<=n*2){
                grid[x][y] = -1;
            }
        }
        for(int i=0;i<=2*n;i++){
            System.out.println();
            for(int j=0;j<=2*n;j++){
                int x = i+xx-n;
                int y = j+yy-n;
                if(x<0 || x>=1000000 || y<0 || y>=1000000){
                    grid[i][j] = -1;
                }
                // System.out.print(grid[i][j]+",");
            }
        }
        cur = new ArrayList<>();
        cur.add(Arrays.asList(xx,yy));
        grid[n][n] = 1;
        while(cur.size()>0 && cur.size()<=n){
            List<List<Integer>> next = new ArrayList<>();
            // System.out.println(cur);
            // System.out.println(cur);
            for(List<Integer> p:cur){
                int x = p.get(0);
                int y = p.get(1);
                if(x==target[0] && y==target[1]){
                    return true;
                }
                int x0,y0;
                x0 = x-1;
                y0 = y;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x+1;
                y0 = y;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x;
                y0 = y-1;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x;
                y0 = y+1;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
            }
            cur = next;
        }
        if(cur.size()==0){
            return false;
        }

        grid = new int[n*2+1][n*2+1];
        xx = target[0];
        yy = target[1];
        for(int i=0;i<blocked.length;i++){
            int x = blocked[i][0]+n-xx;
            int y = blocked[i][1]+n-yy;
            if(x>=0 && x<=n*2 && y>=0 && y<=n*2){
                grid[x][y] = -1;
            }
        }
        for(int i=0;i<=2*n;i++){
            for(int j=0;j<=2*n;j++){
                int x = i+xx-n;
                int y = j+yy-n;
                if(x<0 || x>=1000000 || y<0 || y>=1000000){
                    grid[i][j] = -1;
                }
            }
        }
        cur = new ArrayList<>();
        cur.add(Arrays.asList(xx,yy));
        grid[n][n] = 1;
        while(cur.size()>0 && cur.size()<=n){
            List<List<Integer>> next = new ArrayList<>();
            for(List<Integer> p:cur){
                int x = p.get(0);
                int y = p.get(1);
                if(x==source[0] && y==source[1]){
                    return true;
                }
                int x0,y0;
                x0 = x-1;
                y0 = y;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x+1;
                y0 = y;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x;
                y0 = y-1;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
                x0 = x;
                y0 = y+1;
                if(grid[x0+n-xx][y0+n-yy]==0){
                    next.add(Arrays.asList(x0,y0));
                    grid[x0+n-xx][y0+n-yy] = 1;
                }
            }
            cur = next;
        }
        if(cur.size()==0){
            return false;
        }
        return true;
    }
}
// @lc code=end

