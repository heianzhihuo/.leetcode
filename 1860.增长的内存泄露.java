/*
 * @lc app=leetcode.cn id=1860 lang=java
 *
 * [1860] 增长的内存泄露
 */

// @lc code=start
class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int[] res = new int[3];
        for(int i=1;;i++){
            if(memory1<i && memory2<i){
                res[0] = i;
                res[1] = memory1;
                res[2] = memory2;
                break;
            }
            if(memory2>memory1){
                memory2-=i;
            }else{
                memory1-=i;
            }
        }
        return res;
    }
}
// @lc code=end

