/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int cur = 0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                if(cur%2==1){
                    res[i] = 1;
                }
                cur++;
            }else if(seq.charAt(i)==')'){
                cur--;
                if(cur%2==1){
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

