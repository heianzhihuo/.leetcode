/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n<3){
            return res;
        }
        Arrays.sort(nums);
        for(int k=0;k<n-2;k++){
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int s = -nums[k];
            int i = k+1,j=n-1;
            while(i<j){
                int s0 = nums[i]+nums[j];
                boolean f0 = false;
                boolean f1 = false;
                if(s0==s){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    res.add(tmp);
                    f0 = true;
                    f1 = true;
                }else if(s0>s){
                    f1 = true;
                }else{
                    f0 = true;
                }
                if(f0){
                    while(i<j){
                        i++;
                        if(nums[i]!=nums[i-1]){
                            break;
                        }
                    }
                }
                if(f1){
                    while(i<j){
                        j--;
                        if(nums[j]!=nums[j+1]){
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

