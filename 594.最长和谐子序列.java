/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int s0 = -1;
        int s1 = 1;
        int res = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){
                if(s0 != -1 && nums[j-s1]-nums[j-s1-1]==1){
                    res = Math.max(res,s0+s1);
                }
                s0 = s1;
                s1 = 1;
            }else{
                s1++;
            }
        }
        int n = nums.length;
        if(s0 != -1 && nums[n-s1]-nums[n-s1-1]==1){
            res = Math.max(res,s0+s1);
        }
        return res;
    }
}
// @lc code=end

