/*
 * @lc app=leetcode.cn id=1387 lang=java
 *
 * [1387] 将整数按权重排序
 */

// @lc code=start
class Solution {
    class Node implements Comparable<Node>{
        int val;
        int w;
        public Node(int val){
            this.val = val;
            w = 0;
            while(val!=1){
                w++;
                if(val%2==0){
                    val /= 2;
                }else{
                    val = 3*val+1;
                }
            }
        }
        public int compareTo(Node p){
            if(this.w<p.w){
                return -1;
            }
            if(this.w>p.w){
                return 1;
            }
            if(this.val<p.val){
                return -1;
            }
            if(this.val>p.val){
                return 1;
            }
            return 0;
        }
    }
    public int getKth(int lo, int hi, int k) {
        int n = hi-lo+1;
        Node[] arr = new Node[n];
        for(int i=0;i<n;i++){
            arr[i] = new Node(lo+i);
        }
        Arrays.sort(arr);
        return arr[k-1].val;
    }
}
// @lc code=end

