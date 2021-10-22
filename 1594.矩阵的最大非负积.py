#
# @lc app=leetcode.cn id=1594 lang=python3
#
# [1594] 矩阵的最大非负积
#
# https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix/description/
#
# algorithms
# Medium (30.44%)
# Likes:    25
# Dislikes: 0
# Total Accepted:    3.5K
# Total Submissions: 11.5K
# Testcase Example:  '[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]'
#
# 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
# 
# 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积
# 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
# 
# 返回 最大非负积 对 10^9 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
# 
# 注意，取余是在得到最大积之后执行的。
# 
# 
# 
# 示例 1：
# 
# 输入：grid = [[-1,-2,-3],
# [-2,-3,-3],
# [-3,-3,-2]]
# 输出：-1
# 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
# 
# 
# 示例 2：
# 
# 输入：grid = [[1,-2,1],
# [1,-2,1],
# [3,-4,1]]
# 输出：8
# 解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
# 
# 
# 示例 3：
# 
# 输入：grid = [[1, 3],
# [0,-4]]
# 输出：0
# 解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
# 
# 
# 示例 4：
# 
# 输入：grid = [[ 1, 4,4,0],
# [-2, 0,0,1],
# [ 1,-1,1,1]]
# 输出：2
# 解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= rows, cols <= 15
# -4 <= grid[i][j] <= 4
# 
# 
#

# @lc code=start
class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        dp = [[0,0] for i in range(m)]
        dp[0][0] = min(dp[0][0],grid[0][0])
        dp[0][1] = max(dp[0][0],grid[0][0])
        for j in range(1,m):
            a = dp[j-1][0]*grid[0][j]
            b = dp[j-1][1]*grid[0][j]
            dp[j][0] = min(a,b)
            dp[j][0] = min(0,dp[j][0])
            dp[j][1] = max(a,b)
            dp[j][1] = min(0,dp[j][1])
        print(dp)
        for i in range(1,n):
            a = dp[0][0]*grid[i][0]
            b = dp[0][1]*grid[i][0]
            dp[0][0] = min(a,b)
            dp[0][0] = min(dp[0][0],0)
            dp[0][1] = max(a,b)
            dp[0][1] = max(dp[0][1],0)
            for j in range(1,m):
                x1,y1 = dp[j]
                x2,y2 = dp[j-1]
                z = grid[i][j]
                dp[j][0] = 0
                dp[j][0] = min(dp[j][0],z*x1)
                dp[j][0] = min(dp[j][0],z*x2)
                dp[j][0] = min(dp[j][0],z*y1)
                dp[j][0] = min(dp[j][0],z*y2)
                dp[j][1] = 0
                dp[j][1] = max(dp[j][1],z*x1)
                dp[j][1] = max(dp[j][1],z*x2)
                dp[j][1] = max(dp[j][1],z*y1)
                dp[j][1] = max(dp[j][1],z*y2)
                   
        if dp[m-1][1]>0:
            return dp[m-1][1]
        flag = False
        for i in range(n):
            for j in range(m):
                if grid[i][j]==0:
                    flag = True
                    break 
        if flag:
            return 0
        return -1
        
                


# @lc code=end

