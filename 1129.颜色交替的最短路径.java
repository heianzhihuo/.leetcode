import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 *
 * https://leetcode-cn.com/problems/shortest-path-with-alternating-colors/description/
 *
 * algorithms
 * Medium (37.85%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 16.4K
 * Testcase Example:  '3\n[[0,1],[1,2]]\n[]'
 *
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 * 
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j]
 * 对表示从节点 i 到节点 j 的蓝色有向边。
 * 
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X
 * 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 
 * 
 * 示例 4：
 * 
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 
 * 
 * 示例 5：
 * 
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] ret = new int[n];
        Set<Integer>[][] adj = new Set[n][2];
        for(int i=0;i<n;i++){
            adj[i][0] = new HashSet<>();// red
            adj[i][1] = new HashSet<>();// blue
        }
        for(int i=0;i<red_edges.length;i++){
            adj[red_edges[i][0]][0].add(red_edges[i][1]);
        }
        for(int i=0;i<blue_edges.length;i++){
            adj[blue_edges[i][0]][1].add(blue_edges[i][1]);
        }
        int[][] visited = new int[n][2];// visit_time
        for(int i=0;i<n;i++){
            visited[i][0] = -1;// red come
            visited[i][1] = -1;// blue come
        }
        Set<Integer> cur_red = new HashSet<>();
        Set<Integer> cur_blue = new HashSet<>();
        cur_red.add(0);
        cur_blue.add(0);
        int cur_d = 0;
        while(!cur_red.isEmpty() || !cur_blue.isEmpty()){
            // System.out.println(cur_red+","+cur_blue);
            Set<Integer> next_red = new HashSet<>();
            Set<Integer> next_blue = new HashSet<>();
            for(int x:cur_red){
                if(visited[x][0]==-1){
                    visited[x][0] = cur_d;
                    next_blue.addAll(adj[x][1]);
                }
            }
            for(int x:cur_blue){
                if(visited[x][1]==-1){
                    visited[x][1] = cur_d;
                    next_red.addAll(adj[x][0]);
                }
            }
            cur_d++;
            cur_red = next_red;
            cur_blue = next_blue;
        }
        for(int i=0;i<n;i++){
            // System.out.println(visited[i][0]+","+visited[i][1]);
            ret[i] = visited[i][0];
            if(visited[i][0]==-1 && visited[i][1]==-1){
                ret[i] = -1;
            }else if(visited[i][0]==-1){
                ret[i] = visited[i][1];
            }else if(visited[i][1]==-1){
                ret[i] = visited[i][0];
            }else{
                ret[i] = Math.min(visited[i][0],visited[i][1]);
            }
        }
        return ret;
    }
}
// @lc code=end

