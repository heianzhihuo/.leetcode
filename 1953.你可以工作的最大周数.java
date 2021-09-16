/*
 * @lc app=leetcode.cn id=1953 lang=java
 *
 * [1953] 你可以工作的最大周数
 */

// @lc code=start
class Solution {
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        long s = 0;
        int max = 0;
        for(int i=0;i<milestones.length;i++){
            int x = milestones[i];
            s += x;
            if(x>max){
                max = x;
            }
        }
        long s0 = s - max;
        if(s0+1>=max){
            return s;
        }else
        return s-(max-s0-1);
    }
}
// @lc code=end

