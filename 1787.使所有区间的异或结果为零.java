import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=1787 lang=java
 *
 * [1787] 使所有区间的异或结果为零
 *
 * https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/description/
 *
 * algorithms
 * Hard (65.46%)
 * Likes:    122
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 18.1K
 * Testcase Example:  '[1,2,0,3,0]\n1'
 *
 * 给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left ）的 异或结果 是对下标位于 left 和
 * right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR
 * ... XOR nums[right] 。
 * 
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * ​​​​​​0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minChanges(int[] nums, int k) {
        Map<Integer,Integer>[] map = new Map[k];
        for(int i=0;i<k;i++){
            map[i] = new HashMap<>();
        }
        for(int i=0;i<nums.length;i++){
            map[i%k].put(nums[i],map[i%k].getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] maxArr = new List[k];// 仅找最大的
        for(int i=0;i<k;i++){
            maxArr[i] = new ArrayList<>();
            for(Entry<Integer,Integer> entry:map[i].entrySet()){
                if(maxArr[i].size()==0){
                    maxArr[i].add(entry.getKey());
                }else{
                    
                }
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++) arr[j] = -1;
            DFS(map,arr,0,i);
        }
        return nums.length-mm;
    }
    
    int mm = 0;
    public void DFS(Map<Integer,Integer>[] map,int[] arr,int i,int x){
        if(i==arr.length){
            int tmp = 0;
            int ss = 0;
            for(int a=0;a<arr.length;a++){
                if(a!=x){
                    ss = ss ^ arr[a];
                    tmp += map[a].get(arr[a]);
                }
            }
            tmp += map[x].getOrDefault(ss,0);
            mm = Math.max(mm,tmp);
            return;
        }
        if(i==x){
            DFS(map,arr,i+1,x);
            return;
        }
        for(int t:map[i].keySet()){
            arr[i] = t;
            DFS(map,arr,i+1,x);
            arr[i] = -1;
        }
    }
    
}
// @lc code=end

