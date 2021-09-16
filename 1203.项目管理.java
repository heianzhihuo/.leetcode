/*
 * @lc app=leetcode.cn id=1203 lang=java
 *
 * [1203] 项目管理
 */

// @lc code=start
class Solution {

    
    int[] group;
    int n,m;
    List<List<Integer>> beforeItems;
    int[] res = null;
    int[] groupCount;

    public void DFS(int[] task,int cur,boolean[] visited,int[] visitGroup){
        if(res!=null){
            return;
        }
        if(cur==n){
            res = new int[n];
            for(int i=0;i<n;i++){
                res[i] = task[i];
            }
        }
        int g = -1;
        if(cur>0){
            g = group[task[cur-1]];
        }
        for(int i=0;i<n;i++){
            if(!visited[i] && (g==-1 || visitGroup[g]==groupCount[g] || g==group[i])){
                boolean flag = true;
                for(int x:beforeItems.get(i)){
                    if(!visited[x]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.println(i);
                    task[cur] = i;
                    visited[i] = true;
                    int gg = group[i];
                    if(gg>-1){
                        visitGroup[gg]++;
                    }
                    DFS(task,cur+1,visited,visitGroup);
                    visited[i] = false;
                    if(gg>-1){
                        visitGroup[gg]--;
                    }
                }
            }
        }
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        this.group = group;
        this.m = m;
        this.n = n;
        this.beforeItems = beforeItems;
        groupCount = new int[m];
        for(int i=0;i<m;i++){
            int x = group[i];
            if(x>=0){
                groupCount[x]++;
            }
        }

        int[] task = new int[n];
        boolean[] visited = new boolean[n];
        int[] visitGroup = new int[m];
        DFS(task,0,visited,visitGroup);
        if(res==null){
            return new int[0];
        }
        return res;
    }
}
// @lc code=end

