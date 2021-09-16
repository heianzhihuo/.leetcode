/*
 * @lc app=leetcode.cn id=1547 lang=java
 *
 * [1547] 切棍子的最小成本
 */

// @lc code=start
class Solution {
    //20\n[1,14,18,6,17,8,10,4,13,16,7]\n
    public int minCost(int n, List<Integer> cuts) {
        if(cuts.size()==0){
            return 0;
        }
        if(cuts.size()==1){
            System.out.println(n+":"+cuts);
            return n;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int res = n;
        int m = n/2;
        int x = cuts.get(0);
        for(int y:cuts){
            if(Math.abs(x-m)>Math.abs(y-m)){
                x = y;
            }
        }
        System.out.println(n+","+x+":"+cuts);
        for(int y:cuts){
            if(y>x){
                right.add(y-x);
            }else if(y<x){
                left.add(y);
            }
        }
        res += minCost(x,left)+minCost(n-x,right);
        return res;
    }

    public int minCost(int n, int[] cuts) {
        List<Integer> ccc = new ArrayList<>();
        for(int i=0;i<cuts.length;i++){
            ccc.add(cuts[i]);
        }
        return minCost(n,ccc);
    }
}
// @lc code=end

