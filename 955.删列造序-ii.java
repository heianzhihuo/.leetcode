/*
 * @lc app=leetcode.cn id=955 lang=java
 *
 * [955] 删列造序 II
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        if(n<=1){
            return 0;
        }
        int m = strs[0].length();
        int count = 0;
        boolean[] flag = new boolean[n];
        for(int i=0;i<m;i++){
            boolean[] next = new boolean[n];
            boolean se = true;
            for(int j=1;j<n;j++){
                char a = strs[j-1].charAt(i);
                char b = strs[j].charAt(i);
                if(a<b){
                    next[j] = true;
                }else if(a>b && !flag[j]){
                    se = false;
                }
            }
            if(se){
                for(int j=1;j<n;j++){
                    flag[j] = flag[j] || next[j];
                }
            }else{
                count++;
            }
            
        }
        return count;
    }
}
// @lc code=end

