#
# @lc app=leetcode.cn id=1218 lang=python3
#
# [1218] 最长定差子序列
#

# @lc code=start
class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        n = len(arr)
        dp = {}
        dp[arr[0]] = 1
        m = 1
        for i in range(1,n):
            x = arr[i]
            dpx = 1
            if x not in dp:
                dpx = 1
            y = x - difference
            if y in dp:
                dpx = max(dpx,dp[y]+1)
            dp[x] = dpx
            m = max(dpx,m)
        return m
        
# @lc code=end

