/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        boolean flag = true;
        if(n<0){
            flag = false;
            n = -n;
        }
        Stack<boolean> stack = new Stack<>();
        while(n>0){
            if(n%2==0){
                stack.push(true);
            }else{
                stack.push(false);
            }
            n /= 2;
        }
        return y*y*x;
    }
}
// @lc code=end

