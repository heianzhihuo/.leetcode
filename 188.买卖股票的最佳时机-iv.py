#
# @lc app=leetcode.cn id=188 lang=python3
#
# [188] 买卖股票的最佳时机 IV
#

# @lc code=start
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if n < 2:
            return 0
        profits = []
        i = 0
        for j in range(1, n):
            if prices[j] < prices[j - 1]:
                if prices[j - 1] - prices[i] > 0:
                    profits.append(prices[j - 1] - prices[i])
                i = j
        if prices[n - 1] - prices[i] > 0:
            profits.append(prices[n - 1] - prices[i])
        profits.sort()
        p = 0
        for i in range(k):
            if len(profits)- i - 1 < 0:
                break
            p += profits[-i - 1]
        print(profits)
        return p
        

# @lc code=end

