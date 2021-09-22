/*
 * @lc app=leetcode.cn id=1562 lang=java
 *
 * [1562] 查找大小为 M 的最新分组
 */

// @lc code=start
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(n==m){
            return n;
        }
        boolean[] visited = new boolean[n+2];
        visited[0] = true;
        visited[n+1] = true;
        for(int i=n-1;i>=0;i--){
            int x = arr[i];
            visited[i] = true;
            if(x+m+1<n+2 && visited[x+m+1]){
                boolean flag = true;
                for(int j=x+1;j<x+m+1;j++){
                    if(visited[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return i;
                }
            }
            if(x-m-1>=0 && visited[x-m-1]){
                boolean flag = true;
                for(int j=x-1;j>x-m-1;j--){
                    if(visited[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

