/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s,ans,0,0,new char[]{'(',')'});
        return ans;
    }

    public void remove(String s,List<String> ans,int left,int right,char[] par){
        // 从0-i的子串完成了处理，剩余
        for(int cnt=0,i=left;i<s.length();++i){
            if(s.charAt(i)==par[0]) cnt++;
            if(s.charAt(i)==par[1]) cnt--;
            if(cnt>=0) continue;
            for(int j=right;j<=i;++j){
                if(s.charAt(j)==par[1] && (j==right || s.charAt(j-1)!=par[1])){
                    remove(s.substring(0,j)+s.substring(j+1,s.length()),ans,i,j,par);
                    // 删除j所在的位置), 
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0]=='('){
            remove(reversed,ans,0,0,new char[]{')','('});
        }else{
            ans.add(reversed);
        }
    }
    
}
// @lc code=end

