/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 */

// @lc code=start
class Solution {

    public boolean isPalindrome(String s){
        int i =0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        // blank string
        if(map.containsKey("")){
            int idx = map.get("");
            for(int i=0;i<words.length;i++){
                if(i!=idx && isPalindrome(words[i])){
                    ret.add(Arrays.asList(idx,i));
                    ret.add(Arrays.asList(i,idx));
                }
            }
        }

        // reverse String
        for(int i=0;i<words.length;i++){
            String reverseStr = reverseString(words[i]);
            if(map.containsKey(reverseStr)){
                int idx = map.get(reverseStr);
                if(idx!=i){
                    ret.add(Arrays.asList(idx,i));// 只需要一次，避免重复
                }
            }
        }

        // s1,s2
        for(int i=0;i<words.length;i++){
            String cur = words[i];
            for(int cut =1;cut<cur.length();cut++){
                if(isPalindrome(cur.substring(0,cut))){
                    String cut_r = reverseString(cur.substring(cut,cur.length()));
                    if(map.containsKey(cut_r)){
                        int idx = map.get(cut_r);
                        if(i!=idx){
                            ret.add(Arrays.asList(idx,i));
                        }
                    }
                }
                if(isPalindrome(cur.substring(cut,cur.length()))){
                    String cut_r = reverseString(cur.substring(0,cut));
                    if(map.containsKey(cut_r)){
                        int idx = map.get(cut_r);
                        if(i!=idx){
                            ret.add(Arrays.asList(i,idx));
                        }
                    }
                }
            }
        }

        return ret;
    }
}
// @lc code=end

