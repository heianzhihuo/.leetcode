/*
 * @lc app=leetcode.cn id=1347 lang=java
 *
 * [1347] 制造字母异位词的最小步骤数
 */

// @lc code=start
class Solution {
    public int minSteps(String s, String t) {
        int[] scount = new int[26];
        int[] tcount = new int[26];
        for(int i=0;i<s.length();i++){
            scount[s.charAt(i)-'a']++;
            tcount[t.charAt(i)-'a']++;
        }
        int res = 0;
        for(int i=0;i<26;i++){
            res += Math.abs(scount[i]-tcount[i]);
        }
        return res/2;
    }
}
// @lc code=end

