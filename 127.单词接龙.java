import java.lang.invoke.ClassSpecializer.Factory;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Hard (46.63%)
 * Likes:    910
 * Dislikes: 0
 * Total Accepted:    130.4K
 * Total Submissions: 277K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * 
 * 
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 
 * 
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列
 * 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * endWord.length == beginWord.length
 * 1 
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {

    public boolean isAdj(String w1,String w2){
        int k = 0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                k++;
                if(k>1) break;
            }
        }
        return k==1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int start = -1,end = -1,n = wordList.size();
        for(int i=0;i<n;i++){
            if(beginWord.equals(wordList.get(i))){
                start = i;
            }
            if(endWord.equals(wordList.get(i))){
                end = i;
            }
        }
        if(end==-1) return 0;
        if(start==-1){
            wordList.add(beginWord);
            start = n;
            n++;
        }
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isAdj(wordList.get(i), wordList.get(j))){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        // "hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]
        List<Integer> cur = new ArrayList<>();
        cur.add(start);
        int k = 0;
        boolean[] visited = new boolean[n];
        while(!cur.isEmpty()){
            List<Integer> next = new ArrayList<>();
            // System.out.println(cur);
            k++;
            for(int x:cur){
                visited[x] = true;
                for(int y:adj[x]){
                    if(!visited[y]){
                        next.add(y);
                        if(y==end) return k+1;
                    }
                }
            }
            cur = next;
        }
        return 0;
    }
}
// @lc code=end

