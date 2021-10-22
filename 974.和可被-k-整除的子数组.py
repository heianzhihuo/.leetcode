#
# @lc app=leetcode.cn id=974 lang=python3
#
# [974] 和可被 K 整除的子数组
#

# @lc code=start
class Solution:
    def subarraysDivByK(self, A: List[int], K: int) -> int:
        ss = {0:1}
        s = 0
        ret = 0
        for x in A:
            s += x
            key = s%K

            if key in ss:
                ret += ss[key]
                ss[key]+=1
            else:
                ss[key] = 1
        return ret

# @lc code=end

