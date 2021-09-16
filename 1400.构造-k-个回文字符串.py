#
# @lc app=leetcode.cn id=1400 lang=python3
#
# [1400] 构造 K 个回文字符串
#

# @lc code=start
class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        n = len(s)
        if n<k:
            return False
        if n==k:
            return True
        dic = {}
        for i in range(n):
            ch = s[i]
            if ch in dic:
                dic[ch] += 1
            else:
                dic[ch] = 1
        z = 0
        for ch in dic:
            if dic[ch]%2==1:
                z += 1
        if z<=k:
            return True
        return False
# @lc code=end

