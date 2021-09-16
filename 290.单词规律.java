/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> cur = new HashSet<>();
        String[] arrs = s.split(" ");
        if(arrs.length!=pattern.length()){
            return false;
        }
        boolean ret = true;
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch) && cur.contains(arrs[i])){
                ret = false;
                break;
            }
            if(map.containsKey(ch) && !map.get(ch).equals(arrs[i])){
                ret = false;
                break;
            }
            map.put(ch,arrs[i]);
            cur.add(arrs[i]);
        }
        return ret;
    }
}
// @lc code=end

