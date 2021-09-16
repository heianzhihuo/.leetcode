/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        Arrays.sort(nums);
        int cur = nums[0];
        int res = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<cur){
                res += cur-nums[i];
            }else if(nums[i]>cur){
                cur = nums[i];
            }
            cur++;
        }
        return res;
    }
}
// @lc code=end

