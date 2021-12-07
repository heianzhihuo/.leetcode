/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 *
 * https://leetcode-cn.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (46.90%)
 * Likes:    242
 * Dislikes: 0
 * Total Accepted:    39.4K
 * Total Submissions: 75.2K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:
 * 
 * 
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。       
 * ⁠    第二行同样为左对齐，这是因为这行只包含一个单词。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int cnt = words[0].length(),k = 0;
        for(int i=1;i<words.length;i++){
            if(cnt+words[i].length()+1>maxWidth){
                StringBuilder sb = new StringBuilder();
                sb.append(words[k]);
                int m = i-k;// word个数
                int z = maxWidth-cnt+(m-1);// 空格数
                if(m==1){
                    for(int x=0;x<z;x++){
                        sb.append(" ");
                    }
                }else{
                    int a = z/(m-1);// 平均空格数
                    int b = z%(m-1);//
                    for(int j=0;j<m-1;j++){
                        for(int x=0;x<a;x++){
                            sb.append(" ");
                        }
                        if(j<b) sb.append(" ");
                        sb.append(words[k+1+j]);
                    }
                }
                ret.add(sb.toString());
                k = i;
                cnt = words[k].length();
            }else{
                cnt += words[i].length()+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        cnt = words[k].length();
        sb.append(words[k]);
        k++;
        for(;k<words.length;k++){
            sb.append(" ");
            sb.append(words[k]);
            cnt+= words[k].length()+1;
        }
        for(;cnt<maxWidth;cnt++){
            sb.append(" ");
        }
        ret.add(sb.toString());
        return ret;
    }
}
// @lc code=end

