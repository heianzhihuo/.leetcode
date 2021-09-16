/*
 * @lc app=leetcode.cn id=1627 lang=java
 *
 * [1627] 带阈值的图连通性
 */

// @lc code=start
class Solution {



    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        //  9\n1\n[[6,8],[6,9],[8,9]]\n
        List<Boolean> res = new ArrayList<>();
        
        int[] visited = new int[n];
        int d = 0;
        for(int k=threshold+1;k<=n;k++){
            if(visited[k-1]==0){
                d++;
                int cur = 0;// 是否存在相连的
                for(int i=1;k*i<=n;i++){
                    if(visited[k*i-1]==0){
                        visited[k*i-1] = d;
                    }else{
                        cur = visited[k*i-1];// 已经存在连接
                        break;
                    }
                }
                if(cur>0){
                    for(int i=1;k*i<=n;i++){
                        visited[k*i-1] = cur;
                    }
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(visited[i]);
        // }
        for(int i=0;i<queries.length;i++){
            int x = visited[queries[i][0]-1];
            int y = visited[queries[i][1]-1];
            if(x==y && x!=0){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
// @lc code=end

