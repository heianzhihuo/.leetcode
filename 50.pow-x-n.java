/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==-1) return 1/x;
        if(n==1) return x;
        double ret = myPow(x,n/2);
        if(n%2==0) return ret*ret;
        if(n>0) return ret*ret*x;
        return ret*ret*1.0/x;
    }
}
// @lc code=end

