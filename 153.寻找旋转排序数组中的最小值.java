/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int mm = 5000;
        for(int i=0;i<nums.length;i++){
            mm = Math.min(mm,nums[i]);
        }
        return mm;
    }
}
// @lc code=end

