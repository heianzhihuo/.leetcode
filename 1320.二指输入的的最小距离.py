#
# @lc app=leetcode.cn id=1320 lang=python3
#
# [1320] 二指输入的的最小距离
#

# @lc code=start
class Solution:
    def pos(self,p):
        # O(1)
        z = ord(p) - ord('A')
        x = z // 6#x行
        y = z % 6#y列
        return (x,y)
    def dist(self,p1,p2):
        # O(1)
        z1 = self.pos(p1)
        z2 = self.pos(p2)
        return abs(z1[0]-z2[0])+abs(z1[1]-z2[1])
    def minimumDistance(self, word: str) -> int:
        # 动态规划
        n = len(word)
        if n<=2:
            return 0
        minDist = 300000# 最大距离
        for i in range(1,n):
            cur_dist = 0
            for j in range(1,i):
                cur_dist += self.dist(word[j-1],word[j])
            xx = i-1
            yy = i
            for j in range(i+1,n):
                a = self.dist(word[xx],word[j])
                b = self.dist(word[yy],word[j])
                if a<=b:
                    cur_dist += a
                    xx = j
                else:
                    cur_dist += b
                    yy = j
            minDist = min(cur_dist,minDist)
        return minDist
            
        
        
# @lc code=end

