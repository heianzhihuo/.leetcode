/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    class Node{
        char ch;
        int count;
        Node(char ch,int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int x = map.getOrDefault(ch,0)+1;
            map.put(ch,x);
        }
        List<Node> arr = new ArrayList<>();
        for(char ch:map.keySet()){
            arr.add(new Node(ch,map.get(ch)));
        }
        Collections.sort(arr,(v1,v2)->{
            return v2.count-v1.count;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).count;j++){
                sb.append(arr.get(i).ch);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

