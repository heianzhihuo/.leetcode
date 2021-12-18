/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 *
 * https://leetcode-cn.com/problems/count-the-repetitions/description/
 *
 * algorithms
 * Hard (37.36%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 31.6K
 * Testcase Example:  '"acb"\n4\n"ab"\n2'
 *
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * 
 * 
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 
 * 
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * 
 * 
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * 
 * 
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2,
 * n2] 。
 * 
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s1 和 s2 由小写英文字母组成
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 本质是个周期函数
        // f(n) 表示[s1,n] 可以得到[s2,f(n)]，且f(n)是最大的整数，
        // f(n) 必然存在性质f(n+x) = f(n)+y，只需求出x和y即可求出最终结果
        // 且其中x必然小于等于len(s2)
        int i = 0,j = 0,cnt1 = 0,cnt2 = 0;
        int k1 = s1.length(),k2 = s2.length();
        int[] dp = new int[2*k2];//dp[i] = f(i+1)
        while(cnt1<2*k2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;// 相同，则一起增加
                j++;// 
            }else{
                i++;// 不同，则s1的向右移动
            }
            if(j==k2){
                j = 0;
                cnt2++;
            }
            if(i==k1){
                i = 0;
                dp[cnt1] = cnt2;
                cnt1++;
            }
            
        }
        int x;
        int y = 0;
        for(x=1;x<=k2;x++){
            y = dp[2*k2-1] - dp[2*k2-1-x];// 
            if(dp[2*k2-2]-dp[2*k2-2-x]==y) break;
        }
        // if(x==1) return n1;
        System.out.println(x+","+y);
        int a = n1/x,b = n1%x;
        cnt2 = (a-1)*y+dp[b+x];

        // System.out.println(cnt1+","+cnt2);
        return cnt2/n2;
    }
}
// @lc code=end

