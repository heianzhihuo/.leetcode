/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        int ret = 0;
        int i = 1;
        while(n>0){
            ret += i*(1-n%2);
            n /= 2;
            i *= 2;
        }
        return ret;
    }
}
// @lc code=end

// test
