/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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

    public List<Integer> getNumbers(TreeNode root,int cur){
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        if(root.left==null && root.right==null){
            res.add(cur*10+root.val);
            return res;
        }
        List<Integer> left = getNumbers(root.left,cur*10+root.val);
        List<Integer> right = getNumbers(root.right,cur*10+root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> res = getNumbers(root,0);
        int ret = 0;
        for(int i=0;i<res.size();i++){
            ret += res.get(i);
        }
        return ret;
    }
}
// @lc code=end

