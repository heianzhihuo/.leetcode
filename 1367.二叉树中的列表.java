/*
 * @lc app=leetcode.cn id=1367 lang=java
 *
 * [1367] 二叉树中的列表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean isSub(ListNode head, TreeNode root){
        if(head==null){
            return true;
        }
        if(root!=null && root.val==head.val){
            return isSub(head.next,root.left) || isSub(head.next,root.right);
        }
        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(isSub(head,root)){
            return true;
        }
        if(root==null){
            return false;
        }
        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }
}
// @lc code=end

