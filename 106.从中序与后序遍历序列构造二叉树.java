/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    int postindex,inindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = postorder.length-1;
        inindex = postorder.length-1;
        return buildTree(inorder,postorder,Integer.MAX_VALUE);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder,int rootVal) {
        if(postindex==-1 || inorder[inindex]==rootVal)
            return null;
        TreeNode root = new TreeNode(postorder[postindex]);
        postindex--;
        root.right = buildTree(inorder,postorder,root.val);
        inindex--;
        root.left = buildTree(inorder,postorder,rootVal);
        return root;
    }
}
// @lc code=end

