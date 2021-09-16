/*
 * @lc app=leetcode.cn id=1799 lang=java
 *
 * [1799] N 次操作后的最大分数和
 */

// @lc code=start
class Solution {

    public int gcd(int x,int y) {
        if(x>y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        while(x>0){
            int tmp = y%x;
            y = x;
            x = tmp;
        }
        return y;
    }

    public List<List<Integer>> partion(int n){
        List<List<Integer>> ret = new ArrayList<>();
        if(n==1){
            ret.add(Arrays.asList(0,1));
            return ret;
        }
        List<List<Integer>> sub = partion(n-1);
        for(int i=1;i<n*2;i++){
            int[] arr = new int[n*2-2];
            for(int j=0;j<n*2-2;j++){
                if(j+1>=i){
                    arr[j] = j+2;
                }else{
                    arr[j] = j+1;
                }
            }
            for(int j=0;j<sub.size();j++){
                List<Integer> subret = sub.get(j);
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                tmp.add(i);
                for(int k=0;k<subret.size();k++){
                    tmp.add(arr[subret.get(k)]);
                }
                ret.add(tmp);
            }
            
        }
        return ret;
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] gcdmap = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int x = gcd(nums[i],nums[j]);
                    gcdmap[i][j] = x;
                    gcdmap[j][i] = x;
                }
            }
        }
        List<List<Integer>> path = partion(n/2);
        int ret = 0;
        for(int i=0;i<path.size();i++){
            int[] gcdlist = new int[n/2];
            for(int j=0;j<n/2;j++){
                int x = path.get(i).get(j*2);
                int y = path.get(i).get(j*2+1);
                gcdlist[j] = gcdmap[x][y];
            }
            Arrays.sort(gcdlist);
            int s = 0;
            for(int j=0;j<n/2;j++){
                s += (j+1)*(gcdlist[j]);
            }
            ret = Math.max(s,ret);
        }
        return ret;
    }
}
// @lc code=end

