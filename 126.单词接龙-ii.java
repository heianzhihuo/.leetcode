/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
import java.util.*;
class Solution {
    /**
     * 题目本质，求无向图中的最短路径
     * 给定起点，和终点，因此只需要进行广度优先搜索即可，记录其他点到已知点的最短路径
     */

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

    List<Integer>[] adj;// 邻接表

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       int start = -1,end = -1,n = wordList.size();
       for(int i=0;i<n;i++){
           if(beginWord.equals(wordList.get(i))){
               start = i;
           }
           if(endWord.equals(wordList.get(i))){
               end = i;
           }
       }
       if(end==-1) return new ArrayList<>();
       
       if(start==-1){
           wordList.add(beginWord);
           start = n;
           n++;
       }
       adj = new List[n];
       for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if(isAdj(wordList.get(i), wordList.get(j))){
                   adj[i].add(j);
                   adj[j].add(i);
               }
           }
       }
       List<List<Integer>> cur = new ArrayList<>();
       cur.add(Arrays.asList(start));
       boolean[] visited = new boolean[n];
       while(true){
           List<List<Integer>> next = new ArrayList<>();
           boolean flag = false;
           for(List<Integer> tmp:cur){
               int z = tmp.get(tmp.size()-1);
               visited[z] = true;
               for(int y:adj[z]){
                   if(!visited[y]){
                       List<Integer> tmpNext = new ArrayList<>(tmp);
                       tmpNext.add(y);
                       next.add(tmpNext);
                       if(y==end) flag = true;
                   }
                   
               }
           }
           if(next.size()==0) break;
           cur = next;
           if(flag) break;
           
       }
       // [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
       List<List<String>> ret = new ArrayList<>();
    //    System.out.println(cur);
       for(List<Integer> tmp:cur){
           if(tmp.get(tmp.size()-1)==end){
            List<String> tmpStr = new ArrayList<>();
            for(int x:tmp){
                tmpStr.add(wordList.get(x));
            }
            ret.add(tmpStr);
           }
       }
       return ret;
    }
}
// @lc code=end

