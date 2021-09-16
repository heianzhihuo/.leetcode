/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    // [2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]\n33\n

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key>root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
            return root;
        }
        if(root.right==null){
            return root.left;
        }
        TreeNode p = root.right;// 右子树的最左子树
        if(p.left==null){
            root.val = p.val;
            root.right = p.right;
            return root;
        }
        while(p.left.left!=null){
            p = p.left;
        }
        root.val = p.left.val;
        p.left = p.left.right;
        return root;
    }
}
// @lc code=end

