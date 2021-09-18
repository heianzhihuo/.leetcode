/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int k = 0;
        StringBuilder sb = new StringBuilder();
        while(k<s.length()){
            for(int i=0;i<26;i++){
                if(count[i]>0){
                    sb.append((char)(i+'a'));
                    count[i]--;
                    k++;
                }
            }
            for(int i=25;i>=0;i--){
                if(count[i]>0){
                    sb.append((char)(i+'a'));
                    count[i]--;
                    k++;
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

