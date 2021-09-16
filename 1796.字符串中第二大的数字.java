/*
 * @lc app=leetcode.cn id=1796 lang=java
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        int[] num = new int[10];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if('0'<=ch && ch<='9'){
                num[ch-'0'] = 1;
            }
        }
        int ss = 0;
        for(int i=9;i>=0;i--){
            ss += num[i];
            if(ss==2){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

