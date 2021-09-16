/*
 * @lc app=leetcode.cn id=1255 lang=java
 *
 * [1255] 得分最高的单词集合
 */

// @lc code=start
class Solution {

    int res = 0;
    public void DFS(boolean[] visited,int cur,int[] total,int[][] count,int[] score) {
        if(cur>res){
            res = cur;
        }
        for(int i=0;i<count.length;i++){
            if(!visited[i]){
                int s = 0;
                int j = 0;
                for(;j<26;j++){
                    s += score[j]*count[i][j];
                    if(total[j]<count[i][j]){
                        break;
                    }
                    total[j]-=count[i][j];
                }
                visited[i] = true;
                if(j==26){
                    DFS(visited,cur+s,total,count,score);
                }
                visited[i] = false;
                j--;
                for(;j>=0;j--){
                    total[j]+=count[i][j];
                }
            }
        }
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] total = new int[26];
        int n = words.length;
        for(int i=0;i<letters.length;i++){
            total[letters[i]-'a']++;
        }
        int[][] count = new int[n][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                count[i][words[i].charAt(j)-'a']++;
            }
        }
        boolean[] visited = new boolean[n];
        DFS(visited,0,total,count,score);
        return res;
    }
}
// @lc code=end

