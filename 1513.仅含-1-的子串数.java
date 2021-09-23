/*
 * @lc app=leetcode.cn id=1513 lang=java
 *
 * [1513] 仅含 1 的子串数
 */

// @lc code=start
class Solution {
    public int numSub(String s) {
        int N = s.length();
        long MOD = (int)1e9+7;
        long cnt = 0;
        long res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }else{
                if(cnt>0){
                    res += (cnt+1)*cnt/2;
                    cnt = 0;
                }
            }
        }
        if(cnt>0){
            res += (cnt+1)*cnt/2;
        }
        return (int)(res%MOD);
    }
}
// @lc code=end

