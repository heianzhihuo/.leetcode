/*
 * @lc app=leetcode.cn id=1944 lang=java
 *
 * [1944] 队列中可以看到的人数
 */

// @lc code=start
class Solution {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int cur = 0;
            int count = 0;
            for(int j=i+1;j<n;j++){
                
                if(heights[j]>cur){
                    count++;
                    cur = heights[j];
                    if(heights[j]>heights[i]){
                        break;
                    }
                }
            }
            res[i] = count;
        }
        return res;
    }
}
// @lc code=end

