/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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

    public TreeNode balanceBST(List<Integer> arr,int i,int j) {
        if(i>j){
            return null;
        }
        int m = (i+j)/2;
        TreeNode root = new TreeNode(arr.get(m));
        TreeNode left = balanceBST(arr,i,m-1);
        TreeNode right = balanceBST(arr,m+1,j);
        root.left = left;
        root.right = right;
        return root;
    }

    public void visitTree(TreeNode root,List<Integer> arr){
        if(root!=null){
            visitTree(root.left,arr);
            arr.add(root.val);
            visitTree(root.right,arr);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        visitTree(root,arr);
        return balanceBST(arr,0,arr.size()-1);
    }
}
// @lc code=end

