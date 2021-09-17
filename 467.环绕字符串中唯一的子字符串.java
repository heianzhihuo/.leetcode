/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        if(n<1){
            return 0;
        }
        int[] count = new int[26];
        int curLen = 1;
        count[p.charAt(0)-'a'] = 1;
        for(int i=1;i<n;i++){
            int ch0 = p.charAt(i)-'a';
            int ch1 = p.charAt(i-1)-'a';
            // System.out.println(ch0+","+ch1);
            if(ch0==(ch1+1)%26){
                curLen++;
            }else{
                curLen = 1;
            }
            count[ch0] = Math.max(curLen,count[ch0]);
        }
        int ret = 0;
        for(int x:count){
            // System.out.println(x);
            ret += x;
        }
        return ret;
    }
}
// @lc code=end

