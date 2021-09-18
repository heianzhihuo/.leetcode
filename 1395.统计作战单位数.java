/*
 * @lc app=leetcode.cn id=1395 lang=java
 *
 * [1395] 统计作战单位数
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] count = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(rating[j]>rating[i]){
                    count[i][0]++;
                }
            }
            for(int j=0;j<i;j++){
                if(rating[j]>rating[i]){
                    count[i][1]++;
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(rating[i]<rating[j]){
                    res += count[j][0];
                }else if(rating[i]>rating[j]){
                    res += count[i][1];
                }
            }
        }
        return res;
    }
}
// @lc code=end

