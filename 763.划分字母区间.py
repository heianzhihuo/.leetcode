#
# @lc app=leetcode.cn id=763 lang=python3
#
# [763] 划分字母区间
#

# @lc code=start
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        n = len(S)
        part = []
        x = 0
        y = 0
        for k in range(n):
            z = S.rfind(S[k])
            if z > y:
                y = z
            if k == y:
                part.append(y - x + 1)
                x = k + 1
                y = k + 1
        return part
# @lc code=end

