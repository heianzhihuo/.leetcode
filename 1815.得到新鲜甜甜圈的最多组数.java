/*
 * @lc app=leetcode.cn id=1815 lang=java
 *
 * [1815] 得到新鲜甜甜圈的最多组数
 */

// @lc code=start
class Solution {
    // 2\n[2,4,6,1,2,3,4,5,6,7,8,1,7,8]\n
    public boolean hasSum(int[] map,int x,int d){
        boolean result = false;
        System.out.print(x+","+d+":");
        for(int i=0;i<map.length;i++){
            System.out.print(","+map[i]);
        }
        System.out.println();
        if(d==1){
            for(int i=0;i<map.length;i++){
                if(map[i]==x){
                    map[i] = 0;
                    result = true;
                    break;
                }
            }
        }else{
            for(int i=0;i<map.length;i++){
                int y = map[i];
                if(y>0 && y<x){
                    map[i] = 0;
                    boolean z = hasSum(map,x-y,d-1);
                    if(z){
                        result = true;
                        break;
                    }else{
                        map[i] = y;
                    }
                }
            }
        }
        return result;
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        int res = 0;
        for(int i=0;i<groups.length;i++){
            groups[i] = groups[i]%batchSize;
            if(groups[i]==0){
                res++;
            }
        }
        if(res==0){
            res++;
        }
        for(int k=2;k<=batchSize;k++){
            boolean z = hasSum(groups,batchSize,k);
            while(z){
                res++;
                z = hasSum(groups,batchSize,k);
            }
        }
        return res;
    }
}
// @lc code=end

