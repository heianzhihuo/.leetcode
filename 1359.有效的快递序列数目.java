/*
 * @lc app=leetcode.cn id=1359 lang=java
 *
 * [1359] 有效的快递序列数目
 */

// @lc code=start
class Solution {
    public int countOrders(int n) {
        long a = 1;
        long MOD = 1000000007;
        for(int i=2;i<=n;i++){
            a = (a*i)%MOD;
            long b = (2*i-1)%MOD;
            a = (a*b)%MOD;
        }
        return (int)(a);
    }
}
// @lc code=end

