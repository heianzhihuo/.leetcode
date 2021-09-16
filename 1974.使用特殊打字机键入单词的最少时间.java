/*
 * @lc app=leetcode.cn id=1974 lang=java
 *
 * [1974] 使用特殊打字机键入单词的最少时间
 */

// @lc code=start
class Solution {
    public int distance(char a,char b){
        int x = Math.abs(a-b);
        int y = 26-x;
        return Math.min(x,y);
    }
    public int minTimeToType(String word) {
        int t = 0;
        char ch = 'a';
        for(int i=0;i<word.length();i++){
            char ch2 = word.charAt(i);
            int d = distance(ch,ch2);
            t += d+1;
            ch = ch2;
        }
        return t;
    }
}
// @lc code=end

