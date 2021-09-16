#
# @lc app=leetcode.cn id=915 lang=python3
#
# [915] 分割数组
#

# @lc code=start
class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        n = len(nums)
        k = 0
        m = nums[k]
        while True:
            i = n-1
            while i>=0 and nums[i]>=m:
                i -= 1
            if i<=k:
                break
            flag = True
            for j in range(k,i):
                if nums[j]>m:
                    m = nums[j]
                    flag = False
            k = i
            if flag:
                break
        return k+1
            
                
            
        
# @lc code=end

