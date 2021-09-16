/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int x = asteroids[i];
            if(x>0){
                stack.push(x);
            }else{
                boolean flag = true;
                while(!stack.isEmpty()){
                    int y = stack.peek();
                    if(y<0){
                        break;
                    }
                    if(y>-x){
                        flag = false;
                        break;
                    }
                    if(y==-x){
                        flag = false;
                        stack.pop();
                        break;
                    }
                    stack.pop();
                }
                if(flag){
                    stack.push(x);
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
// @lc code=end

