/*
 * @lc app=leetcode.cn id=1514 lang=java
 *
 * [1514] 概率最大的路径
 */

// @lc code=start
class Solution {

    class Pair implements Comparable<Pair>{
        int node;
        double pro;
        public Pair(int node,double pro){
            this.node = node;
            this.pro = pro;
        }
        public int compareTo(Pair p){
            if(this.pro == p.pro){
                return 0;
            }else if(this.pro-p.pro>0){
                return -1;
            }else{
                return 1;
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] adjList = new List[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adjList[x].add(new Pair(y,succProb[i]));
            adjList[y].add(new Pair(x,succProb[i]));
        }
        PriorityQueue<Pair> que = new PriorityQueue<>();
        double[] prob = new double[n];
        que.offer(new Pair(start,1));
        prob[start] = 1;
        while(!que.isEmpty()){
            Pair pair = que.poll();
            double pr = pair.pro;
            int node = pair.node;
            if(pr<prob[node]){
                continue;
            }
            for(Pair pairNext:adjList[node]){
                int nodeNext = pairNext.node;
                double proNext = pairNext.pro;
                if(prob[nodeNext]<prob[node]*proNext){
                    prob[nodeNext] = prob[node]*proNext;
                    que.offer(new Pair(nodeNext,prob[nodeNext]));
                }
            }
        }
        return prob[end];
    }
}
// @lc code=end

