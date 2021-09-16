#
# @lc app=leetcode.cn id=1552 lang=python3
#
# [1552] 两球之间的磁力
#

# @lc code=start
class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()#所有位置从左到右排序
        MAX_LEN = position[-1] - position[0] + 1
        n = len(position)
        for i in range(n-m):
            a = MAX_LEN # 较小的
            b = MAX_LEN # 较大大
            c = -1 # 删除位置
            for j in range(1,len(position)-1):
                x = position[j]-position[j-1]
                y = position[j+1] - position[j]
                if x>y:
                    x,y = y,x
                if x<a or (x==a and y<b):
                    a,b,c = x,y,j
            position.pop(c)
            print(position)
        ret = MAX_LEN
        
        for i in range(1,len(position)):
            ret = min(ret,position[i]-position[i-1])
        return ret
            
        




# @lc code=end

