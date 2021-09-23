/*
 * @lc app=leetcode.cn id=1639 lang=java
 *
 * [1639] 通过给定词典构造目标字符串的方案数
 */

// @lc code=start
class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        long MOD = (long)1e9+7;
        int[][]cnt = new int[n][26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<n;j++){
                cnt[j][words[i].charAt(j)-'a']++;
            }
        }
        long[][] dp = new long[m][n];
        for(int i=0;i<m;i++){
            int ch = target.charAt(i)-'a';
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j] = cnt[j][ch];
                }
                if(i>0 && j>0 && dp[i-1][j-1]>0){
                    dp[i][j] += cnt[j][ch]*dp[i-1][j-1];
                    dp[i][j] %= MOD;
                }
                if (j>0){
					dp[i][j] += dp[i][j-1];
					dp[i][j] %= MOD;
				}
            }
        }
        return (int)(dp[m-1][n-1]);
    }
}
// @lc code=end

