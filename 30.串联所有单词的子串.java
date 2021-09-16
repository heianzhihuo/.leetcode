/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(words);
        for(int i=0;i<=n-m*k;i++){
            String[] cur = new String[m];
            for(int j=0;j<m;j++){
                cur[j] = s.substring(i+j*k,i+j*k+k);
            }
            Arrays.sort(cur);
            boolean flag = true;
            for(int j=0;j<m;j++){
                if(!cur[j].equals(words[j])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

