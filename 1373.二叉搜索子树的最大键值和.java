/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
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

    int res = 0;
    public int[] DFS(TreeNode root){
        int[] ret = new int[2];
        if(root==null){
            return ret;
        }
        int[] left = DFS(root.left);
        int[] right = DFS(root.right);
        ret[1] = left[1]+right[1]+root.val;
        if(left[0]==1 || right[0]==1){
            ret[0] = 1;
        }
        if(root.left!=null){
            TreeNode tmp  = root.left;// 左节点的最右子树
            while(tmp.right!=null){
                tmp = tmp.right;
            }
            if(tmp.val>=root.val){
                ret[0] = 1;
            }
        }
        if(root.right!=null){
            TreeNode tmp = root.right;// 右节点最左子树
            while(tmp.left!=null){
                tmp = tmp.left;
            }
            if(tmp.val<=root.val){
                ret[0] = 1;
            }
        }
        if(ret[0]==0){
            res = Math.max(res,ret[1]);
        }
        return ret;
    }

    public int maxSumBST(TreeNode root) {
        res = 0;
        int[] ret = DFS(root);
        return res;
    }
}
// @lc code=end

