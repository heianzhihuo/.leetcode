/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i+=2){
            ret += nums[i];
        }
        return ret;
    }
}
// @lc code=end

