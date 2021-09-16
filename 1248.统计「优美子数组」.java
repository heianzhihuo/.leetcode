/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ret = 0;
        int n = nums.length;
        List<Integer> odd = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                odd.add(i);
            }
        }
        if(odd.size()<k){
            return 0;
        }
        for(int i=0;i+k-1<odd.size();i++){
            int x = odd.get(i);
            int y = odd.get(i+k-1);
            int x0 = -1;
            if(i>0){
                x0 = odd.get(i-1);// 前一个
            }
            int y0 = n;
            if(i+k<odd.size()){
                y0 = odd.get(i+k);// 后一个
            }
            ret += (x-x0)*(y0-y);
        }
        return ret;
    }
}
// @lc code=end

