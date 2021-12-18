import java.util.List;

/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 *
 * https://leetcode-cn.com/problems/number-of-paths-with-max-score/description/
 *
 * algorithms
 * Hard (35.52%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    3.6K
 * Total Submissions: 9.9K
 * Testcase Example:  '["E23","2X2","12S"]\r'
 *
 * 给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。
 * 
 * 你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍
 * 'X'。在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。
 * 
 * 一条路径的 「得分」 定义为：路径上所有数字的和。
 * 
 * 请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对 10^9 + 7 取余。
 * 
 * 如果没有任何路径可以到达终点，请返回 [0, 0] 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = ["E23","2X2","12S"]
 * 输出：[7,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = ["E12","1X1","21S"]
 * 输出：[4,2]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：board = ["E11","XXX","11S"]
 * 输出：[0,0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= board.length == board[i].length <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1000000007;
        int n = board.size();
        int[][] table = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch = board.get(i).charAt(j);
                if(ch=='X') table[i][j] = -1;
                else if('0'<=ch && ch<='9') table[i][j] = ch - '0';
            }
        }
        int[][][] dp = new int[n][n][2];//
        dp[n-1][n-1][0] = 0;
        dp[n-1][n-1][1] = 1;// 路径数
        for(int i=n-2;i>=0;i--){
            if(table[n-1][i]==-1) break;
            dp[n-1][i][0] = dp[n-1][i+1][0]+table[n-1][i];
            dp[n-1][i][1] = 1;
        }
        for(int i=n-2;i>=0;i--){
            if(table[i][n-1]==-1) break;
            dp[i][n-1][0] = dp[i+1][n-1][0]+table[i][n-1];
            dp[i][n-1][1] = 1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(table[i][j]!=-1){
                    int x = Math.max(dp[i][j+1][0],dp[i+1][j][0]);
                    x = Math.max(x,dp[i+1][j+1][0]);
                    dp[i][j][0] = x+table[i][j];
                    if(x==dp[i][j+1][0]) dp[i][j][1] = (dp[i][j][1]+dp[i][j+1][1])%MOD;
                    if(x==dp[i+1][j][0]) dp[i][j][1] = (dp[i][j][1]+dp[i+1][j][1])%MOD;
                    if(x==dp[i+1][j+1][0]) dp[i][j][1] = (dp[i][j][1]+dp[i+1][j+1][1])%MOD;
                }
            }
        }
        int[] ret = new int[2];
        ret[1] = dp[0][0][1];
        ret[0] = dp[0][0][0];
        if(ret[1]==0) ret[0] = 0;
        return ret;
    }
}
// @lc code=end

