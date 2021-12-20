/*
 * @lc app=leetcode.cn id=1664 lang=java
 *
 * [1664] 生成平衡数组的方案数
 *
 * https://leetcode-cn.com/problems/ways-to-make-a-fair-array/description/
 *
 * algorithms
 * Medium (54.43%)
 * Likes:    28
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 10.3K
 * Testcase Example:  '[2,1,6,4]'
 *
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * 
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * 
 * 
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 
 * 
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * 
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */
// n = 6
//      0 1 2 3 4 5
//  0 1 2 3 4 5 6 7
// i = 2
// sum[i] = nums[0]
// sum[i+1] = nums[1]
// sum[n] - sum[i] = nums[2,4]
// sum[n+1] - sum[i+1] = nums[3,5]
// 删掉i，则此时，


// i = 3
// sum[i] = nums[1]
// sum[i+1] = nums[0,2]
// sum[n+1]-sum[i] = nums[5,7]
// sum[n] - sum[i+1] = nums[4]
// @lc code=start
class Solution {
    public int waysToMakeFair(int[] nums) {
        // 奇数下标和偶数下标和
        int n = nums.length;
        int[] sum = new int[n+2];// 0-对应位置的和
        for(int i=0;i<n;i++) sum[i+2] = sum[i]+nums[i];
        int cnt = 0;
        for(int i=0;i<n;i++){
            int a = sum[i];// 0-i  不包含i
            int b = sum[i+1];// 0-i 
            if(i%2==n%2){
                int c = sum[n]-sum[i] - nums[i];
                int d = sum[n+1]-sum[i+1];
                if(a+d==b+c) cnt++;
            }else{
                int c = sum[n+1]-sum[i] - nums[i];
                int d = sum[n]-sum[i+1];
                if(a+d==b+c) cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end

