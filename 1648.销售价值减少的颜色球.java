/*
 * @lc app=leetcode.cn id=1648 lang=java
 *
 * [1648] 销售价值减少的颜色球
 */

// @lc code=start
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int MOD = 1000000007;
        int ret = 0;
        Arrays.sort(inventory);
        int n = inventory.length;
        int i = 1;
        while(orders>0){
            int x = inventory[n-i];
            int y = 0;
            if(i<n){
               y = inventory[n-i-1];
            }
            int d = x-y;
            if(d*i>=orders){
                int k = orders/i;
                int z = orders-i*k;
                ret = (ret + (z*x)%MOD)%MOD;
                int tmp = (2*x-k+1)%(2*MOD);
                tmp = tmp*k%(2*MOD);
                tmp = tmp*i%(2*MOD);
                tmp = tmp / 2;
                ret = (ret+tmp)%MOD;
                break;
            }
            int tmp = (x+y-1)%(2*MOD);
            tmp = tmp*(d+1)%(2*MOD);
            tmp = tmp / 2;
            ret = (ret+tmp)%MOD;
            orders -= d*i;
            i++;
        }
        return ret;
    }
}
// @lc code=end

