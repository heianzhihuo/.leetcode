#
# @lc app=leetcode.cn id=1710 lang=python3
#
# [1710] 卡车上的最大单元数
#

# @lc code=start
class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key = lambda x:x[1])
        boxTypes.reverse()
        unitSum = 0
        for box in boxTypes:
            if truckSize>= box[0]:
                unitSum += box[0]*box[1]
                truckSize -= box[0]
            else:
                unitSum += truckSize*box[1]
                truckSize = 0
            if truckSize == 0:
                break
        return unitSum
# @lc code=end

