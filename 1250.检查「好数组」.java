/*
 * @lc app=leetcode.cn id=1250 lang=java
 *
 * [1250] 检查「好数组」
 */

// @lc code=start
class Solution {

    public int gcd(int x,int y){
        if(x>y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        while(x>0){
            int tmp = y%x;
            y = x;
            x = tmp;
        }
        return y;
    }

    public boolean isGoodArray(int[] nums) {
        // nums是否互为素数
        if(nums.length==1){
            return nums[0]==1;
        }
        int n = nums.length;
        int g = gcd(nums[0],nums[1]);
        if(nums[0]==1 || nums[1]==1){
            return true;
        }
        for(int i=2;i<n;i++){
            if(nums[i]==1){
                return true;
            }
            if(g==1){
                return true;
            }
            g = gcd(g,nums[i]);
        }
        return g==1;
    }
}
// @lc code=end

