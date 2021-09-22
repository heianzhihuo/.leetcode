/*
 * @lc app=leetcode.cn id=1862 lang=java
 *
 * [1862] 向下取整数对和
 */

// @lc code=start
class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int N = (int)1e5;
        int MOD = (int)1e9+7;
        int[] cnt = new int[N+1];
        for(int x:nums){
            cnt[x]++;
        }
        int[] preCnt = new int[N+1];
        for(int i=1;i<=N;i++){
            preCnt[i] = preCnt[i-1] + cnt[i];
        }
        long res = 0;
        for(int i=1;i<=N;i++){
            if(cnt[i]!=0){
                long sum = 0;
                for(int j=1;i*j<=N;j++){
                    int x = i*j-1;
                    int y = i*(j+1)-1;
                    int count = preCnt[Math.min(N,y)] - preCnt[x];
                    sum += count*j;
                }
                res = (res + (sum%MOD)*cnt[i])%MOD;
            }
        }
        return (int)res;
    }
}
// @lc code=end

