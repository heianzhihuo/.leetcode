/*
 * @lc app=leetcode.cn id=1880 lang=java
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
class Solution {
    public int toInt(String s){
        int x = 1;
        int res = 0;
        for(int i=s.length()-1;i>=0;i--){
            res += x*(s.charAt(i)-'a');
            x *= 10;
        }
        return res;
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int x = toInt(firstWord);
        int y = toInt(secondWord);
        int z = toInt(targetWord);
        return x+y==z;
    }
}
// @lc code=end

