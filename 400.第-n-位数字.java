/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        int count = 0;
        int i = 1;
        int k = 1;
        while((count+i*9*k)<n){
            count += (i*9*k);
            i *= 10;
            k++;
        }
        int x = n-count;
        int y = x/k-1+i;
        int z = x%k
        
    }
}
// @lc code=end

