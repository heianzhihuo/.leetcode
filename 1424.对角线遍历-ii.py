#
# @lc app=leetcode.cn id=1424 lang=python3
#
# [1424] 对角线遍历 II
#

# @lc code=start
import functools
class Solution:
    def cmp(self, a, b):
        if a[1] > b[1]:
            return 1
        elif a[1] < b[1]:
            return - 1
        elif a[2] > b[2]:
            return 1
        elif a[2] < b[2]:
            return - 1
        return 0
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        tmp = []
        for i in range(len(nums)):
            for j in range(len(nums[i])):
                tmp.append([nums[i][j], i + j, i])
        tmp = sorted(tmp, key=functools.cmp_to_key(cmp))
        ret = []
        for x in tmp:
            ret.append(x[0])
        return ret
        

                
# @lc code=end

