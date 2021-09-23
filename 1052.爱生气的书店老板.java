/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int s = 0;
        int a = 0;
        int cur = 0;// 不生气
        for(int i=0;i<n;i++){
            s += (1-grumpy[i])*customers[i];
            if(i<minutes){
                cur += grumpy[i]*customers[i];
            }else{
                cur += grumpy[i]*customers[i];
                cur -= grumpy[i-minutes]*customers[i-minutes];
            }
            a = Math.max(a,cur);
            // System.out.println(cur);
        }
        // System.out.println(s);
        return s+a;
    }
}
// @lc code=end

