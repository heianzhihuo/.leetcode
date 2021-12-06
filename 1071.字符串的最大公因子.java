/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 *
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/description/
 *
 * algorithms
 * Easy (58.63%)
 * Likes:    212
 * Dislikes: 0
 * Total Accepted:    34.8K
 * Total Submissions: 59.3K
 * Testcase Example:  '"ABCABC"\n"ABC"'
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * str1[i] 和 str2[i] 为大写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 求出str1的最小循环长度
        int k,n1 = str1.length(),n2 = str2.length();// 循环长度
        for(k=1;k<=n1;k++){
            if(n1%k==0){
                //能整除
                boolean flag = true;
                for(int i=k;i<n1;i++){
                    if(str1.charAt(i)!=str1.charAt(i%k)){
                        flag = false;
                        break;
                    }
                }
                if(flag) break;
            }
        }
        // 判断str1的循环长度是否是str2的循环长度
        if(n2%k!=0) return "";
        boolean flag = true;
        for(int i=0;i<n2;i++){
            if(str2.charAt(i)!=str1.charAt(i%k)){
                flag = false;
                break;
            }
        }
        if(!flag) return "";
        int a = n1/k,b = n2/k;
        if(a<b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(b>0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        String pattern = str1.substring(0, k);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a;i++){
            sb.append(pattern);
        }
        return sb.toString();
    }
}
// @lc code=end

