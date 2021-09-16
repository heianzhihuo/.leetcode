/*
 * @lc app=leetcode.cn id=829 lang=java
 *
 * [829] 连续整数求和
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for(int k=1;k*k<2*n;k++){
            if((n-k*(k-1)/2)%k==0) count++;
        }
        return count;
    }
}
// @lc code=end

