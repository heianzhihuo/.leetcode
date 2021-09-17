/*
 * @lc app=leetcode.cn id=1601 lang=java
 *
 * [1601] 最多可达成的换楼请求数目
 */

// @lc code=start
class Solution {

    int res;
    public void DFS(List<Integer> path,int x,int[][] map,int n) {
        System.out.println(path+":"+x);
        int k = path.size();
        for(int i=0;i<k;i++){
            if(path.get(i)==x){
                int d = map[path.get(k-1)][x];
                for(int j=i;j<k-1;j++){
                    d = Math.min(d,map[path.get(j)][path.get(j+1)]);
                }
                res += d*(k-i);
                map[path.get(k-1)][x] -= d;
                for(int j=i;j<k-1;j++){
                    map[path.get(j)][path.get(j+1)] -= d;
                }
                return;
            }
        }
        path.add(x);
        for(int i=0;i<n;i++){
            if(map[x][i]>0){
                DFS(path,i,map,n);
            }
        }
        path.remove(k);
    }

    public int maximumRequests(int n, int[][] requests) {
        int[][] map = new int[n][n];
        for(int i=0;i<requests.length;i++){
            map[requests[i][0]][requests[i][1]]++;
        }
        res = 0;
        for(int i=0;i<n;i++){
            res += map[i][i];
            map[i][i] = 0;
        }
        System.out.println(res);
        //[[1,2],[2,2],[0,0],[1,1],[0,2],[0,0],[2,1],[0,1],[1,0],[2,2],[0,1],[2,0],[2,2]]
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]+",");
            }
        }
        for(int k=0;k<n;k++){
            List<Integer> tmp = new ArrayList<>();
            DFS(tmp,k,map,n);
            System.out.println("cur size"+res);
        }
        return res;
    }
}
// @lc code=end

