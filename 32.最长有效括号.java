/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // ")()(()())))"\n
        int left = -1;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    left = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        res = Math.max(i-left,res);
                    }else{
                        res = Math.max(res,i-stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

