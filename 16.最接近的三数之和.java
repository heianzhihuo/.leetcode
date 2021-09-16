/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = 100000;
        int res = -1;
        for(int k=0;k<n-2;k++){
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            for(int i=k+1;i<n-1;i++){
                int d = Math.abs(nums[k]+nums[i]+nums[n-1]-target);
                if(d<diff){
                    res = nums[k]+nums[i]+nums[n-1];
                    diff = d;
                }
                for(int j=n-2;j>i;j--){
                    int s = nums[k]+nums[i]+nums[j];
                    int d1 = Math.abs(s-target);
                    if(d1>d){
                        break;
                    }
                    if(d1<diff){
                        res = s;
                        diff = d1;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

