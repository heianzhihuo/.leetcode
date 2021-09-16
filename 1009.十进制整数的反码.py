#
# @lc app=leetcode.cn id=1009 lang=python3
#
# [1009] 十进制整数的反码
#

# @lc code=start
class Solution:
    def bitwiseComplement(self, n: int) -> int:
        x = 0
        y = 1
        if n == 0:
            return 1
        while n>0:
            x += (y*(1-n%2))
            n //= 2
            y *= 2
        return x
# @lc code=end

