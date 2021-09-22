/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        int n1 = s1.length();
        int n2 = s2.length();
        if(n2<n1){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            cnt[s1.charAt(i)-'a']++;
        }
        int[] cnt2 = new int[26];
        
        for(int i=0;i<n1;i++){
            cnt2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<=n2-n1;i++){
            boolean flag = true;
            for(int j=0;j<26;j++){
                if(cnt[j]!=cnt2[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
            if(i<n2-n1){
                cnt2[s2.charAt(i)-'a']--;
                cnt2[s2.charAt(i+n1)-'a']++;
            }
        }


        return false;
    }
}
// @lc code=end

