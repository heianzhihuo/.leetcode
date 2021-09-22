/*
 * @lc app=leetcode.cn id=1589 lang=java
 *
 * [1589] 所有排列中的最大和
 */

// @lc code=start
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] count = new int[n];
        for(int i=0;i<requests.length;i++){
            int a = requests[i][0];
            int b = requests[i][1];
            count[a]++;
            if(b+1<n){
                count[b+1]--;
            }
        }
        for(int i=1;i<n;i++){
            count[i] += count[i-1];
        }
        Arrays.sort(count);
        Arrays.sort(nums);
        long res = 0;
        int MOD = 1000000007;
        for(int i=n-1;i>=0 && count[i]>0;i--){
            res += (long)nums[i]*count[i];
        }
        return (int)(res%MOD);
    }
}
// @lc code=end

