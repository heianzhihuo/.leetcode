/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int title = 0;
        int n = columnTitle.length();
        int s = 1;
        for(int i=n-1;i>=0;i--){
            int x = columnTitle.charAt(i)-'A'+1;
            title += x*s;
            s*=26;
        }
        return title;
    }
}
// @lc code=end

