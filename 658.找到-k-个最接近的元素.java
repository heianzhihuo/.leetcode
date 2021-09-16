/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int i = 0,j = n;
        while(i<j){
            int m = (j-i)/2+i;
            int y = arr[m];
            if(x==y){
                j = m;
            }else if(x>y){
                i = m+1;
            }else{
                j = m;
            }
        }
        List<Integer> ret = new ArrayList<>();
        j = i+1;
        while(k>0){
            if(j>=n || (i>=0  && arr[j]-x>=x-arr[i])){
                ret.add(arr[i]);
                i--;
            }
            if(i<=0 || (j<n && arr[j]-x<=x-arr[i])){
                ret.add(arr[j]);
                j++;
            }
            k--;
        }
        Collections.sort(ret);
        return ret;
    }
}
// @lc code=end

