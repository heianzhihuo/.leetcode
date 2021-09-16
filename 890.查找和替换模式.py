#
# @lc app=leetcode.cn id=890 lang=python3
#
# [890] 查找和替换模式
#

# @lc code=start
class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        ret = []
        for i in range(len(words)):
            cntemp = [-1 for j in range(26)]
            word = words[i]
            flag = True
            for j in range(len(word)):
                x = ord(word[j]) - ord('a')
                y = ord(pattern[j]) - ord('a')
                if cntemp[y]==-1:
                    if x in cntemp:
                        flag = False
                        break
                    cntemp[y] = x
                elif cntemp[y]!=x:
                    flag = False
                    break
            if flag:
                ret.append(word)
        return ret
# @lc code=end

