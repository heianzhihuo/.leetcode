/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
import java.util.TreeMap;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int x:arr){
            map.put(x,1);
        }
        int cur = 1;
        for(int key:map.keySet()){
            map.put(key,cur);
            cur++;
        }
        int[] ret = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ret[i] = map.get(arr[i]);
        }
        return ret;
    }
}
// @lc code=end

