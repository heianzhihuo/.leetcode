/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            long s = 0;
            for(TreeNode t:cur){
                s += t.val;
                if(t.left!=null){
                    next.add(t.left);
                }
                if(t.right!=null){
                    next.add(t.right);
                }
            }
            ret.add(s*1.0/cur.size());
            cur = next;
        }
        return ret;
    }
}
// @lc code=end

