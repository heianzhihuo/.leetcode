/*
 * @lc app=leetcode.cn id=1048 lang=java
 *
 * [1048] 最长字符串链
 */

// @lc code=start
class Solution {
    boolean isMatch(String p,String t){
        boolean flag = true;
        for(int i=0;i<t.length();i++)
            if(flag){
                if(p.charAt(i)!=t.charAt(i)){
                    if(p.charAt(i+1)!=t.charAt(i))
                        return false;// 
                    flag = false;
                }  
            }else{
                if(p.charAt(i+1)!=t.charAt(i))
                    return false;
            }
        return true;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        List<String> []cache = new List[16];
        List<Integer> []longest = new List[16];
        int i,j,k,ret = 1;
        for(i=0;i<16;i++){
            cache[i] = new ArrayList<>();
            longest[i] = new ArrayList<>();
        }
        for(i=0;i<n;i++){
            j = words[i].length();
            cache[j-1].add(words[i]);// 设置最长的长度
            longest[j-1].add(1);
        }
        for(i=1;i<16;i++){
            for(j=0;j<cache[i].size();j++){
                int t = longest[i].get(j);
                
                for(k=0;k<cache[i-1].size();k++){
                    if(isMatch(cache[i].get(j),cache[i-1].get(k))){
                        t = Math.max(t,longest[i-1].get(k)+1);
                    }
                        
                }
                longest[i].set(j,t);
                ret = Math.max(ret,t);
            }
        }
        return ret;
    }
}
// @lc code=end

