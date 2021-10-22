#
# @lc app=leetcode.cn id=1360 lang=python3
#
# [1360] 日期之间隔几天
#
# https://leetcode-cn.com/problems/number-of-days-between-two-dates/description/
#
# algorithms
# Easy (49.57%)
# Likes:    32
# Dislikes: 0
# Total Accepted:    7.3K
# Total Submissions: 14.7K
# Testcase Example:  '"2019-06-29"\n"2019-06-30"'
#
# 请你编写一个程序来计算两个日期之间隔了多少天。
# 
# 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
# 
# 
# 
# 示例 1：
# 
# 输入：date1 = "2019-06-29", date2 = "2019-06-30"
# 输出：1
# 
# 
# 示例 2：
# 
# 输入：date1 = "2020-01-15", date2 = "2019-12-31"
# 输出：15
# 
# 
# 
# 
# 提示：
# 
# 
# 给定的日期是 1971 年到 2100 年之间的有效日期。
# 
# 
#

# @lc code=start
class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        import time
        start = time.mktime(time.strptime(date1,'%Y-%m-%d'))
        end = time.mktime(time.strptime(date2,'%Y-%m-%d'))
        count_days = int((end - start)/(24*60*60))
        if count_days<0:
            count_days = -count_days
        return count_days
# @lc code=end

