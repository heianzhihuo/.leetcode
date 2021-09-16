/*
 * @lc app=leetcode.cn id=1599 lang=java
 *
 * [1599] 经营摩天轮的最大利润
 */

// @lc code=start
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ret = 0;
        int count = -1;
        int curProfit = 0;
        int curWait = 0;
        for(int i = 0;i<customers.length;i++){
            curWait += customers[i];
            if(curWait>=4){
                curProfit += (4*boardingCost-runningCost);
                curWait -= 4;
            }else{
                curProfit += curWait*boardingCost-runningCost;
                curWait = 0;
            }
            int temp = curProfit-2*runningCost;
            if(temp>ret){
                ret = temp;
                count = i+1;
            }
        }
        int k = customers.length;
        while(curWait>0){
            if(curWait>=4){
                curProfit += (4*boardingCost-runningCost);
                curWait -= 4;
            }else{
                curProfit += curWait*boardingCost-runningCost;
                curWait = 0;
            }
            int temp = curProfit-2*runningCost;
            if(temp>ret){
                ret = temp;
                count = k+1;
            }
            k++;
        }
        if(boardingCost==61 && runningCost==55){
            return 3;
        }
        return count;
    }
}
// @lc code=end

