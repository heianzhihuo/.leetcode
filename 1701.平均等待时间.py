#
# @lc app=leetcode.cn id=1701 lang=python3
#
# [1701] 平均等待时间
#

# @lc code=start
class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        waitTime = 0
        curTime = 0
        for i in range(len(customers)):
            arrivali = customers[i][0]
            timei = customers[i][1]
            if arrivali>=curTime:
                waitTime += timei
                curTime = arrivali+timei
            else:
                waitTime += (curTime+timei - arrivali)
                curTime += timei
        return waitTime / len(customers)
# @lc code=end

