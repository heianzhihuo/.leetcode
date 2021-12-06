import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1079 lang=java
 *
 * [1079] 活字印刷
 *
 * https://leetcode-cn.com/problems/letter-tile-possibilities/description/
 *
 * algorithms
 * Medium (73.43%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    11.5K
 * Total Submissions: 15.6K
 * Testcase Example:  '"AAB"'
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 
 * 注意：本题中，每个活字字模只能使用一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 
 * 
 * 示例 2：
 * 
 * 输入："AAABBC"
 * 输出：188
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<String> wordSet = new HashSet<>();
    StringBuilder curStr;
    boolean[] visited;
    String tiles;
    public int numTilePossibilities(String tiles) {
        // tiles长度最多为7，直接暴力方法求所有全排列，并用Set去重
        this.tiles = tiles;
        curStr = new StringBuilder();
        visited = new boolean[tiles.length()];
        DFS();
        return wordSet.size();
    }

    public void DFS(){
        if(curStr.length()!=0){
            wordSet.add(curStr.toString());
        }
        for(int i=0;i<tiles.length();i++){
            if(!visited[i]){
                visited[i] = true;
                curStr.append(tiles.charAt(i));
                DFS();
                curStr.deleteCharAt(curStr.length()-1);
                visited[i] = false;
            }
        }
    }


}
// @lc code=end

