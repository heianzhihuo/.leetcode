/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int n = prices.length;
        if(n<2){
            return 0;
        }
        int cur = prices[0];
        for(int i=1;i<prices.length;i++){
            int x = prices[i];
            if(x>cur){
                sum += (x-cur);
            }
            cur = x;
        }
        return sum;
    }
}
// @lc code=end

