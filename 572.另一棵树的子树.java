/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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

    public boolean isSame(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root!=null && subRoot!=null){
            if(root.val!=subRoot.val){
                return false;
            }
            return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSame(root,subRoot)){
            return true;
        }
        if(root!=null){
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
        return false;
    }
}
// @lc code=end

