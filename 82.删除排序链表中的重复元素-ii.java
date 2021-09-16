/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head;
        // head
        while(ret!=null){
            ListNode p = ret.next;
            while(p!=null){
                if(ret.val!=p.val){
                    break;
                }
                p = p.next;
            }
            if(p!=ret.next){
                ret = p;
            }else{
                break;// head 不变
            }
        }
        if(ret==null){
            return null;
        }
        // other
        ListNode tail = ret;
        ListNode h0 = tail.next;
        while(h0!=null){
            ListNode p = h0.next;
            while(p!=null){
                if(h0.val!=p.val){
                    break;
                }
                p = p.next;
            }
            if(p!=h0.next){
                h0 = p;
                tail.next = null;
            }else{
                tail.next = h0;
                tail = tail.next;
                h0 = h0.next;
            }
        }
        return ret;
    }
}
// @lc code=end

