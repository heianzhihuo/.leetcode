/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find max index
        int max_index = -1;
        int n = mountainArr.length();
        int i=0,j=n-1;
        while(i<j){
            int mid = (i+j)/2;
            int x = mountainArr.get(mid);
            int y = mountainArr.get(mid-1);
            int z = mountainArr.get(mid+1);
            if(x>y && x>z){
                max_index = mid;
                break;
            }else if(y>x){
                j = mid;
            }else {
                i = mid;
            }
        }
        // binary search left
        i = 0;j = max_index;
        while(i<=j){
            int mid = (i+j)/2;
            int x = mountainArr.get(mid);
            if(x==target){
                return mid;
            }else if(x<target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        i = max_index;j = n-1;
        while(i<=j){
            int mid = (i+j)/2;
            int x = mountainArr.get(mid);
            if(x==target){
                return mid;
            }else if(x>target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

