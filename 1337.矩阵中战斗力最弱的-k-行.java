/*
 * @lc app=leetcode.cn id=1337 lang=java
 *
 * [1337] 矩阵中战斗力最弱的 K 行
 */

// @lc code=start
class Solution {

    class Node implements Comparable<Node>{
        int n,x;
        public Node(int n,int x){
            this.n = n;
            this.x = x;
        }
        public int compareTo(Node p){
            if(n<p.n){
                return 1;
            }else if(n>p.n){
                return -1;
            }else if(x<p.x){
                return 1;
            }else if(x>p.x){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int j = 0;
            for(;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    break;
                }
            }
            Node p = new Node(j,i);
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int[] res = new int[k];
        for(int i=k-1;i>=0;i--){
            res[i] = queue.poll().x;
        }
        return res;
    }
}
// @lc code=end

