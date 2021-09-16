/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0,index2 = 0;
        int mid1 = 0,mid2 = 0;// 
        for(int i=0;i<=(nums1.length+nums2.length)/2;i++){
            mid1 = mid2;
            if(index1==nums1.length){
                mid2 = nums2[index2];
                index2++;
            }else if(index2==nums2.length){
                mid2 = nums1[index1];
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                mid2 = nums2[index2];
                index2++;
            }else{
                mid2 = nums1[index1];
                index1++;
            }
        }
        if((nums1.length+nums2.length)%2==0){
            return (double)(mid1+mid2)/2;
        }
        return mid2;
    }
}
// @lc code=end

