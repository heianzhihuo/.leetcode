/*
 * @lc app=leetcode.cn id=1805 lang=java
 *
 * [1805] 字符串中不同整数的数目
 *
 * https://leetcode-cn.com/problems/number-of-different-integers-in-a-string/description/
 *
 * algorithms
 * Easy (49.69%)
 * Likes:    19
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 24.6K
 * Testcase Example:  '"a123bc34d8ef34"'
 *
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34"
 * 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：word = "leet1234code234"
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * word 由数字和小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDifferentIntegers(String word) {

    }
}
// @lc code=end

