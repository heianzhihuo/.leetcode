/*
 * @lc app=leetcode.cn id=805 lang=java
 *
 * [805] 数组的均值分割
 */

// @lc code=start
class Solution {

    public boolean splitSum(Map<Integer,Integer> map,int x,int d){
        if(d==0 && x==0){
            return true;
        }
        if(d==0 || x<0){
            return false;
        }
        boolean ret = false;
        for(int y:map.keySet()){
            if(x>=y){
                int k = map.get(y);
                if(k>0){
                    map.put(y,k-1);
                    ret = ret || splitSum(map,x-y,d-1);
                    map.put(y,k);
                    if(ret){
                        break;
                    }
                }
            }
        }
        return ret;
    }
    

    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return false;
        }
        int s = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int a = nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
            s += a;
        }
        boolean ret = false;
        for(int i=1;i<=n/2;i++){
            if((s*i)%n==0){
                ret = ret || splitSum(map,s*i/n,i);
                if(ret){
                    break;
                }
            }
        }
        
        return ret;
    }
}
// @lc code=end

