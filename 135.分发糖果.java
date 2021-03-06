import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 *
 * https://leetcode-cn.com/problems/candy/description/
 *
 * algorithms
 * Hard (48.35%)
 * Likes:    718
 * Dislikes: 0
 * Total Accepted:    108.5K
 * Total Submissions: 223.1K
 * Testcase Example:  '[1,0,2]'
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 
 * 
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 
 * 
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * ⁠    第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n];
        int ret = 0;;
        for(int i=0;i<n;i++){
            if((i==0 || ratings[i-1]>=ratings[i]) && (i==n-1 || ratings[i]<=ratings[i+1])){
                dp[i] = 1;
            }
        }
        while(true){
            int[] next = new int[n];
            // System.out.println();
            int cnt = 0;
            for(int i=0;i<n;i++){
                if(dp[i]==0){
                    if(i==0 && dp[i+1]!=0) next[i] = dp[i+1]+1;
                    if(i==n-1 && dp[i-1]!=0) next[i] = dp[i-1]+1;
                    if(i>0 && i<n-1 && dp[i-1]+dp[i+1]!=0){
                        if(dp[i-1]!=0 && dp[i+1]!=0) next[i] = Math.max(dp[i-1],dp[i+1])+1;
                        if(dp[i-1]==0 && ratings[i-1]>=ratings[i]) next[i] = dp[i+1]+1;
                        if(dp[i+1]==0 && ratings[i+1]>=ratings[i]) next[i] = dp[i-1]+1;
                    }
                }else next[i] = dp[i];
                if(next[i]==0) cnt++;
                // System.out.print(next[i]+",");
            }
            dp = next;
            if(cnt==0) break;
        }
        for(int i=0;i<n;i++){
            ret+= dp[i];
        }
        return ret;
    }
}
// @lc code=end

