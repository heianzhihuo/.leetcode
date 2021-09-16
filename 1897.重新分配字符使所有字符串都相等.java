/*
 * @lc app=leetcode.cn id=1897 lang=java
 *
 * [1897] 重新分配字符使所有字符串都相等
 */

// @lc code=start
class Solution {
    public boolean makeEqual(String[] words) {
        int[] map = new int[26];
        for(String word:words){
            for(int i=0;i<word.length();i++){
                map[word.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(map[i]%words.length!=0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

