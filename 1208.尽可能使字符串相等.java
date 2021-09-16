/*
 * @lc app=leetcode.cn id=1208 lang=java
 *
 * [1208] 尽可能使字符串相等
 */

// @lc code=start
class Solution {
    // "anryddgaqpjdw"\n"zjhotgdlmadcf"\n5\n
// "zjhotgdlmadcf"
// 5
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int res = 0;
        int cur = 0,k=0;
        for(int j=0;j<n;j++){
            cur += Math.abs(s.charAt(j)-t.charAt(j));
            if(cur<=maxCost){
                res = Math.max(res,j-k+1);
            }
            while(k<=j){
                if(cur<=maxCost){
                    break;
                }
                cur -= Math.abs(s.charAt(k)-t.charAt(k));
                k++;
            }
        }
        if(cur<=maxCost){
            res = Math.max(res,n-k);
        }
        return res;
    }
}
// @lc code=end

