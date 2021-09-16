#
# @lc app=leetcode.cn id=1263 lang=python3
#
# [1263] 推箱子
#

# @lc code=start
class Solution:
    
    def minPushBox(self, grid: List[List[str]]) -> int:
        sx = 0
        sy = 0
        bx = 0
        by = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 'S':
                    sx = i
                    sy = j
                elif grid[i][j] == 'B':
                    bx = i
                    by = j
        path = [(sx,sy,bx,by)]
        self.ret = -1
        self.move(grid,path,0)
        return self.ret

    def move(self,grid,path,count):
        print(path)
        x,y,bx,by = path[-1]
        if x >= len(grid) or x<0 or y<0 or y>= len(grid[0]):
            return
        if bx >= len(grid) or bx<0 or by<0 or by>= len(grid[0]):
            return
        if grid[x][y] == '#':
            # 移动到了墙上
            return
        if (x,y,bx,by) in path[:-1]:
            # 状态重复
            return
        if grid[bx][by] == '#':
            # 箱子推墙上了
            return
        if grid[bx][by] == 'T':
            # 箱子达到目标位置
            if self.ret == -1 or count < self.ret:
                self.ret = count
            return
        direction = [(-1,0),(1,0),(0,-1),(0,1)] # 移动方向，上下左右
        for d in direction:
            nx = x + d[0]
            ny = y + d[1]
            nbx = bx
            nby = by
            nc = count
            if nx == bx and ny==by:
                nc = count + 1
                nbx = bx + d[0]
                nby = by + d[1]
            self.move(grid,path+[(nx,ny,nbx,nby)],nc)
        



    
        
        
# @lc code=end

