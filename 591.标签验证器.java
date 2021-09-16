/*
 * @lc app=leetcode.cn id=591 lang=java
 *
 * [591] 标签验证器
 */

// @lc code=start
class Solution {

    public boolean isValid(String code) {
        int cur = -1;
        Stack<String> tagStack = new Stack<>();
        boolean cdata = false;
        int i = 0;
        boolean root = false;
        if(code.charAt(0)!='<'){
            return false;
        }
        while(i<code.length()){
            if(root && cur==-1 && tagStack.isEmpty()){
                return false;
            }
            if(cdata){
                if(code.startsWith("]]>",i)){
                    cdata = false;
                    i += 3;
                    continue;
                }
            }else{
                if(code.charAt(i)=='<'){
                    if(code.startsWith("<![CDATA[",i)){
                        if(!root){
                            return false;
                        }
                        cdata = true;
                        i += 9;
                        continue;
                    }
                    if(cur!=-1){
                        return false;
                    }
                    cur = i;
                }else if(code.charAt(i)=='>'){
                    if(cur!=-1){
                        if(i-cur<2){
                            return false;
                        }
                        String tag = code.substring(cur+1,i);
                        if(tag.charAt(0)=='/'){
                            tag = tag.substring(1);
                            if(tagStack.isEmpty() || !tagStack.pop().equals(tag)){
                                return false;
                            }
                        }else{
                            if(tag.length()==0 || tag.length()>9){
                                return false;
                            }
                            for(int j=0;j<tag.length();j++){
                                if(tag.charAt(j)<'A' || tag.charAt(j)>'Z'){
                                    return false;
                                }
                            }
                            if(tagStack.isEmpty() && root){
                                return false;
                            }
                            tagStack.push(tag);
                            root = true;
                        }
                        cur = -1;
                    }
                }
            }
            i++;
        }
        if(cur!=-1 || cdata || !tagStack.isEmpty()){
            return false;
        }
        return true;
    }
}
// @lc code=end

