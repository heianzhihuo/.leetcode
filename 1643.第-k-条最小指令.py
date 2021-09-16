#
# @lc app=leetcode.cn id=1643 lang=python3
#
# [1643] 第 K 条最小指令
#

# @lc code=start
class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        m = destination[0]
        n = destination[1]
        dp = [[1 for j in range(n)] for i in range(m)]
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j]+dp[i][j-1]
        path = ""
        while k>0:
            if m-1>0 and k>dp[m-2][n-1]:
                k -= dp[m-2][n-1]
                path = path + "V"
                n -= 1
            else:
                m -= 1
                path = path +"H"
        return path
# @lc code=end

