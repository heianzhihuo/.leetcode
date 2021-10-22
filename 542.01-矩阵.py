#
# @lc app=leetcode.cn id=542 lang=python3
#
# [542] 01 矩阵
#

# @lc code=start
class Solution:
    
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        n = len(matrix)
        m = len(matrix[0])
        visited = [[-1 for i in range(m)] for j in range(n)]
        cur = set()
        for i in range(n):
            for j in range(m):
                if matrix[i][j]==0:
                    cur.add((i,j))
        dis = 0
        while len(cur)>0:
            next = set()
            for (x,y) in cur:
                visited[x][y] = dis
                if x>0 and visited[x-1][y]==-1 and (x-1,y) not in cur:
                    next.add((x-1,y))
                if x<n-1 and visited[x+1][y] == -1 and (x+1,y) not in cur:
                    next.add((x+1,y))
                if y>0 and visited[x][y-1]==-1 and (x,y-1) not in cur:
                    next.add((x,y-1))
                if y<m-1 and visited[x][y+1] == -1 and (x,y+1) not in cur:
                    next.add((x,y+1))
            cur = next
            dis += 1
        return visited


        
# @lc code=end

