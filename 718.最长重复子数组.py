#
# @lc app=leetcode.cn id=718 lang=python3
#
# [718] 最长重复子数组
#
# https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/description/
#
# algorithms
# Medium (55.32%)
# Likes:    428
# Dislikes: 0
# Total Accepted:    58.7K
# Total Submissions: 105.5K
# Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
#
# 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
# 
# 
# 
# 示例：
# 
# 输入：
# A: [1,2,3,2,1]
# B: [3,2,1,4,7]
# 输出：3
# 解释：
# 长度最长的公共子数组是 [3, 2, 1] 。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= len(A), len(B) <= 1000
# 0 <= A[i], B[i] < 100
# 
# 
#

# @lc code=start
class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        # 最长公共子串
        n1 = len(nums1)
        n2 = len(nums2)
        dp = [[0 for i in range(n1)] for j in range(n2)]
        j = nums2.index(nums1[0])
        if j>=0:
            for i in range(j,n2):
                dp[0][i] = 1
        j = nums1.index(nums2[0])
        if j>=0:
            for i in range(j,n1):
                dp[i][0] = 1
        for i in range(1,n1):
            for j in range(1,n2):
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                if nums1[i]==nums2[j]:
                    dp[i][j] = max(dp[i][j],dp[i-1][j-1]+1)
        return dp[n1-1][n2-1]

# @lc code=end

