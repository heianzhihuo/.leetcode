#
# @lc app=leetcode.cn id=878 lang=python3
#
# [878] 第 N 个神奇数字
#

# @lc code=start
class Solution:

    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        import math
        lcm = a * b // math.gcd(a, b)
        left, right = 2, 10 ** 14
        while left <= right:
            mid = (left + right) // 2
            N = mid // a + mid // b - mid // lcm
            if N >= n:
                right = mid - 1
            else:
                left = mid + 1
        return left%(10**9+7)
        
            
            
        
        
        
        
        
# @lc code=end

