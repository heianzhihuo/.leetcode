/*
 * @lc app=leetcode.cn id=1424 lang=java
 *
 * [1424] 对角线遍历 II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> tmp = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                List<Integer> t = new ArrayList<>();
                t.add(nums.get(i).get(j));
                t.add(i+j);
                t.add(i);
                tmp.add(t);
            }
        }
        tmp.sort((v1,v2)->{
            if(v1.get(1)>v2.get(1)){
                return 1;
            }else if(v1.get(1)<v2.get(1)){
                return -1;
            }else if(v1.get(2)>v2.get(2)){
                return -1;
            }else if(v1.get(2)<v2.get(2)){
                return 1;
            }
            return 0;
        });
        int[] ret = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            ret[i] = tmp.get(i).get(0);
        }
        return ret;
    }
}
// @lc code=end

