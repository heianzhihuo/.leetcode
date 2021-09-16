#
# @lc app=leetcode.cn id=313 lang=python3
#
# [313] 超级丑数
#

# @lc code=start
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        k = len(primes)
        uglyp = [0 for i in range(k)]
        ugly = [1]
        for i in range(n-1):
            cur = ugly[uglyp[0]]*primes[0]
            for j in range(1,k):
                cur = min(ugly[uglyp[j]]*primes[j],cur)
            ugly.append(cur)
            for j in range(0,k):
                if cur%primes[j]==0:
                    uglyp[j] = i+1
            print(ugly)
        return ugly[n-1]
        
# @lc code=end

