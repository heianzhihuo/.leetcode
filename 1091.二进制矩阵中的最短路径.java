import java.util.List;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 *
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (37.64%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    28.7K
 * Total Submissions: 75.9K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * 
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n -
 * 1)）的路径，该路径同时满足下述要求：
 * 
 * 
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 
 * 
 * 畅通路径的长度 是该路径途经的单元格总数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 
 * grid[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
        public Node(){

        }
        @Override
        public boolean equals(Object p){
            if(p instanceof Node){
                Node t = (Node)p;
                return t.x==x && t.y==y;
            }
            return false;
        }
        @Override
        public String toString(){
            return "("+x+","+y+")";
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==0){
            return -1;
        }
        if(grid[0][0]==1){
            return -1;
        }
        Node target = new Node(n-1,n-1);
        List<Node> cur = new ArrayList<>();
        cur.add(new Node(0,0));
        int ret = 1;
        while(!cur.isEmpty()){
            // System.out.println(cur);
            List<Node> next = new ArrayList<>();
            for(Node p:cur){
                if(p.equals(target)) return ret;
                grid[p.x][p.y] = 1;
                List<Node> adj = getAdj(p.x,p.y,n);
                for(Node q:adj){
                    if(next.indexOf(q)==-1 && grid[q.x][q.y]==0){
                        next.add(q);
                    }
                }
            }
            ret++;
            cur = next;
        }
        return -1;
    }

    public List<Node> getAdj(int x,int y,int n){
        List<Node> adj = new ArrayList<>();
        if(x>0) adj.add(new Node(x-1,y));
        if(x<n-1) adj.add(new Node(x+1,y));
        if(y>0) adj.add(new Node(x,y-1));
        if(y<n-1) adj.add(new Node(x,y+1));
        if(x>0 && y>0) adj.add(new Node(x-1,y-1));
        if(x>0 && y<n-1) adj.add(new Node(x-1,y+1));
        if(x<n-1 && y>0) adj.add(new Node(x+1,y-1));
        if(x<n-1 && y<n-1) adj.add(new Node(x+1,y+1));
        return adj;
    }
}
// @lc code=end

