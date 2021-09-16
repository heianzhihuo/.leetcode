#
# @lc app=leetcode.cn id=222 lang=python3
#
# [222] 完全二叉树的节点个数
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: TreeNode) -> int:
        count = 0
        if not root:
            return 0
        cur = [root]
        while len(cur)>0:
            next = []
            for node in cur:
                count+=1
                if node.left:
                    next.append(node.left)
                if node.right:
                    next.append(node.right)
            cur = next
        return count


# @lc code=end

