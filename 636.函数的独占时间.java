/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int time[] = new int[n];
        int cur = -1;
        Stack<Integer> stack = new Stack<>();
        for(String logStr:logs){
            String[] log = logStr.split(":");
            int task = Integer.valueOf(log[0]);
            int t0 = Integer.valueOf(log[2]);
            if(log[1].equals("start")){
                if(stack.size()>0){
                    int top = stack.peek();
                    time[top] += (t0-cur-1);
                }
                stack.push(task);
                cur = t0-1;
            }else{
                int top = stack.pop();
                time[top] += (t0-cur);
                cur = t0;
            }
        }
        return time;
    }
}
// @lc code=end

