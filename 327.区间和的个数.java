/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/description/
 *
 * algorithms
 * Hard (42.56%)
 * Likes:    368
 * Dislikes: 0
 * Total Accepted:    25.2K
 * Total Submissions: 59.9K
 * Testcase Example:  '[-2,5,-1]\n-2\n2'
 *
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和
 * upper）之内的 区间和的个数 。
 * 
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0], lower = 0, upper = 0
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -2^31 
 * -10^5 
 * 题目数据保证答案是一个 32 位 的整数
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 思路：先求所有S[i+1] = nums[0]+nums[1]+...+nums[i]
        // 对S排序，然后，查找每个一个数x，用二分查找
        // 对应x+lower 和x+upper的范围
        // 时间复杂度 nlogn
        int n = nums.length;
        long[] S = new long[n+1];
        for(int i=0;i<n;i++){
            S[i+1] += S[i] + nums[i];
            System.out.println(S[i+1]);
        }
        Arrays.sort(S);
        int res = 0;
        for(int i=0;i<n+1;i++){
            long x = S[i];
            int a = searchLeft(S,x+lower);
            int b = searchRight(S, x+upper);
            System.out.println(x+","+a+","+b);
            if(a<=b) res += b-a+1;
        }
        return res/2;
    }
    /*
     * 左侧边界
     */
    public int searchLeft(long[] S,long x){
        if(S.length==0) return -1;
        int i = 0,j = S.length;
        while(i<j){
            int m = (i+j)/2;
            if(S[m]<x){
                i = m+1;
            }else{
                j = m;
            }
        }
        return i;
    }

    /*
     * 右侧边界
     */
    public int searchRight(long[] S,long x){
        if(S.length==0) return -1;
        int i = 0,j = S.length;
        while(i<j){
            int m = (i+j)/2;
            if(S[m]<=x){
                i = m+1;
            }else{
                j = m;
            }
        }
        return i-2;
    }

}
// @lc code=end

