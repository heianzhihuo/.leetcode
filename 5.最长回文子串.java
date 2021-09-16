/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = s.substring(0,1);
        int x = 0,y = 1;
        for(int k=1;k<n;k++){
            int i = k-1;
            int j = k+1;
            while(i>=0 && j<n){
                if(s.charAt(i)!=s.charAt(j)){
                    break;
                }
                i--;
                j++;
            }
            if(j-i-1>y-x){
                x = i+1;
                y = j;
            }
            i = k-1;
            j = k;
            while(i>=0 && j<n){
                if(s.charAt(i)!=s.charAt(j)){
                    break;
                }
                i--;
                j++;
            }
            if(j-i-1>y-x){
                x = i+1;
                y = j;
            }

        }
        return s.substring(x,y);
    }
}
// @lc code=end

