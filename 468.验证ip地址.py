#
# @lc app=leetcode.cn id=468 lang=python3
#
# [468] 验证IP地址
#

# @lc code=start
class Solution:
    def validIPAddress(self, IP: str) -> str:
        arr = IP.split(".")
        if len(arr)==4:
            for x in arr:
                if not x.isnumeric():
                    return "Neither"
                if x[0]=='0' and len(x)!=1:
                    return "Neither"
                a = int(x)
                if a>255:
                    return "Neither"
            return "IPv4"
        arr = IP.split(":")
        if len(arr)==8:
            for x in arr:
                x = x.upper()
                if len(x)>4 or len(x)==0:
                    return "Neither"
                for t in x:
                    if not ((t>='0' and t<='9') or (t>="A" and t<="F")):
                        return "Neither"
            return "IPv6"
        return "Neither"

# @lc code=end
