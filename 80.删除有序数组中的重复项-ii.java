/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int count = 1;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                count = 1;
            }else if(count<2){
                i++;
                nums[i] = nums[j];
                count++;
            }
        }
        return i+1;
    }
}
// @lc code=end

