/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ret = 0;

    public int DFS(TreeNode root){
        int sum = 0;
        if(root==null){
            return sum;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        sum = left+right+root.val;
        ret += Math.abs(left-right);
        return sum;
    }

    public int findTilt(TreeNode root) {
        DFS(root);
        return ret;
    }
}
// @lc code=end

