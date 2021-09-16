#
# @lc app=leetcode.cn id=73 lang=python3
#
# [73] 矩阵置零
#

# @lc code=start
from typing import MutableSet


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        0 1 2 0
        3 4 5 2
        1 3 1 5

        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        fx = 1
        fy = 1
        for i in range(m):
            if matrix[i][0] == 0:
                fx = 0
                break
        for j in range(n):
            if matrix[0][j] == 0:
                fy = 0
                break
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    matrix[0][j] = 0
                    matrix[i][0] = 0
        for i in range(1,m):
            for j in range(1,n):
                if matrix[0][j] == 0 or matrix[i][0] == 0:
                    matrix[i][j] = 0
        if fx==0:
            for i in range(m):
                matrix[i][0] = 0
        if fy==0:
            for j in range(n):
                matrix[0][j] = 0

        
# @lc code=end

