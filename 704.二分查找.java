/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while(i<=j){
            int mid = (j-i)/2+i;
            int x = nums[mid];
            if(target==x){
                return mid;
            }else if(target>x){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

