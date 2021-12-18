/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
import java.util.*;
class Solution {

    class Node{
        int[] data;

        public Node(){
            this.data = new int[21];
        }

        public Node(Node node){
            this.data = Arrays.copyOf(node.data,21);
        }

        @Override
        public int hashCode(){
            int s = 0;
            for(int i=0;i<21;i++) s += data[i];
            return s;
        }

        @Override
        public boolean equals(Object o){
            if(!(o instanceof Node)) return false;
            Node t = (Node) o;
            for(int i=0;i<21;i++){
                if(data[i]!=t.data[i]) return false;
            }
            return true;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;// 此题只能用穷举方法，时间至多为2^n<=2^10
        // 且
        int[] cnt = new int[21];
        for(int i=0;i<nums.length;i++){
            cnt[nums[i]+10]++;
        }
        HashSet<Node> ret = new HashSet<>();
        HashSet<Node> cur = new HashSet<>();
        cur.add(new Node());
        while(!cur.isEmpty()){
            HashSet<Node> next = new HashSet<>();
            ret.addAll(cur);
            for(Node node:cur){
                for(int i=0;i<21;i++){
                    if(node.data[i]+1<=cnt[i]){
                        Node tmp = new Node(node);
                        tmp.data[i]++;
                        next.add(tmp);
                    }
                }
            }
            cur = next;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Node node:ret){
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<21;i++){
                // System.out.print(node.data[i]);
                for(int j=0;j<node.data[i];j++){
                    tmp.add(i-10);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
// @lc code=end

