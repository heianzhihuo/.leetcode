#
# @lc app=leetcode.cn id=781 lang=python3
#
# [781] 森林中的兔子
#

# @lc code=start
class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        answers.sort()
        n = len(answers)
        if n == 0:
            return 0
        if n == 1:
            return answers[0] + 1
        s = 0
        i = 0
        for j in range(0,n):
            if j == n - 1 or answers[j] != answers[j + 1]:
                x = answers[i]
                d = j - i + 1
                aa = d // (x + 1)
                bb = d % (x + 1)
                
                if bb == 0:
                    s = s + (x + 1) * (aa)
                else:
                    s = s + (x + 1) * (aa + 1)
                i = j + 1
        return s
        
        
# @lc code=end

