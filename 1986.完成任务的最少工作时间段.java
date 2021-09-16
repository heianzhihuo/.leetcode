/*
 * @lc app=leetcode.cn id=1986 lang=java
 *
 * [1986] 完成任务的最少工作时间段
 */

// @lc code=start
class Solution {

    Map<Integer,Integer> map;
    List<Integer> taskList;
    List<Integer> ret;
    int left = 15;
    public void SplitSum(int x,List<Integer> cur) {
        if(x<left){
            left = x;
            ret = new ArrayList<>(cur);
        }
        for(int i=taskList.size()-1;i>=0;i--){
            int y = taskList.get(i);
            int k = map.get(y);
            if(x>=y && k>0){
                map.put(y,k-1);
                cur.add(y);
                SplitSum(x-y,cur);
                cur.remove(cur.size()-1);
                map.put(y,k);
            }
        }
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = tasks[i];
            map.put(x,map.getOrDefault(x,0)+1);
        }
        taskList = new ArrayList<>(map.keySet());
        Collections.sort(taskList);
        int count = 0;
        int s = 0;
        while(s<n){
            List<Integer> cur = new ArrayList<>();
            left = 15;
            ret = new ArrayList<>();
            SplitSum(sessionTime,cur);
            for(int x:ret){
                map.put(x,map.get(x)-1);
            }
            System.out.println(ret);
            count++;
            s+=ret.size();
        }
        return count;
    }
}
// @lc code=end

