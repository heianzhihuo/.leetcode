/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            ugly[i] = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                ugly[i] = Math.min(ugly[i],primes[j]*ugly[idx[j]]);
            }
            for(int j = 0;j<primes.length;j++){
                while(primes[j]*ugly[idx[j]]<=ugly[i]) idx[j]++;
            }
        }
        return ugly[n-1];
    }
}
// @lc code=end

