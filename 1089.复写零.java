/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> zero = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i+zero.size()*2>=arr.length){
                break;
            }
            if(arr[i]==0){
                zero.add(i);
            }
        }
        int cur = zero.size()-1;
        for(int i=arr.length-1;i>=0;i--){
            if(cur<0) break;
            if(i-cur>zero.get(cur)){
                arr[i] = arr[i-cur-1];
            }else{
                arr[i] = 0;
                cur--;
            }
        }
    }
}
// @lc code=end

