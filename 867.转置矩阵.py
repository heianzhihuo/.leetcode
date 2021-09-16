#
# @lc app=leetcode.cn id=867 lang=python3
#
# [867] 转置矩阵
#

# @lc code=start
class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])
        trans = [[0 for i in range(m)] for j in range(n)]
        for i in range(m):
            for j in range(n):
                trans[j][i] = matrix[i][j]
        return trans
# @lc code=end

