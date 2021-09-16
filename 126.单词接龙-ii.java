/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public boolean isAdj(String p1,String p2){
        if(p1.length()!=p2.length()){
            return false;
        }
        int count = 0;
        for(int i=0;i<p1.length();i++){
            if(p1.charAt(i)!=p2.charAt(i)){
                count++;
            }
            if(count>=2){
                break;
            }
        }
        return count==1;
    }

    List<List<String>> ret = new ArrayList<>();
    Map<String,Set<String>> adjMap;

    public void DFS(String beginWord, String endWord,Stack<String> cur) {
        if(ret.size()!=0 && cur.size()+1>ret.get(0).size()){
            return;
        }
        if(beginWord.equals(endWord)){
            if(ret.size()!=0 && cur.size()+1<ret.get(0).size()){
                ret = new ArrayList<>();
            }
            List<String> sol = new ArrayList<>(cur);
            sol.add(beginWord);
            ret.add(sol);
            return;
        }
        cur.push(beginWord);
        for(String word:adjMap.get(beginWord)){
            if(cur.indexOf(word)==-1){
                DFS(word,endWord,cur);
            }
        }
        cur.pop();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        adjMap = new HashMap<>();
        if(wordList.indexOf(endWord)==-1){
            return ret;
        }
        wordList.add(beginWord);
        for(String word:wordList){
            adjMap.put(word,new HashSet<>());
        }
        for(int i=0;i<wordList.size()-1;i++){
            for(int j=i+1;j<wordList.size();j++){
                String p1 = wordList.get(i);
                String p2 = wordList.get(j);
                if(isAdj(p1,p2)){
                    Set<String> adj1 = adjMap.get(p1);
                    adj1.add(p2);
                    Set<String> adj2 = adjMap.get(p2);
                    adj2.add(p1);
                }
            }
        }
        Stack<String> cur = new Stack<>();
        DFS(beginWord,endWord,cur);
        return ret;
    }
}
// @lc code=end

