/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String res = "";
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()>0){
                res = res + " "+ arr[i];
            }
        }
        return res.substring(1);
    }
}
// @lc code=end

