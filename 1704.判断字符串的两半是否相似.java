/*
 * @lc app=leetcode.cn id=1704 lang=java
 *
 * [1704] 判断字符串的两半是否相似
 */

// @lc code=start
class Solution {
    public boolean halvesAreAlike(String s) {
        List<Character> clist = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        Set<Character> vset = new HashSet<>(clist);
        int a = 0;
        int b = 0;
        for(int i=0;i<s.length();i++){
            if(vset.contains(s.charAt(i))){
                if(i>=s.length()/2){
                    a++;
                }else{
                    b++;
                }
            }
        }
        return a==b;
    }
}
// @lc code=end

