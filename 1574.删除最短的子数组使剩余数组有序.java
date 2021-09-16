/*
 * @lc app=leetcode.cn id=1574 lang=java
 *
 * [1574] 删除最短的子数组使剩余数组有序
 */

// @lc code=start
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if(n<=1){
            return 0;
        }
        int a = -1,b = n;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                a = i-1;
                break;
            }
        }
        if(a==-1){
            return 0;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                b = i+1;
                break;
            }
        }
        int m = Math.max(a+1,n-b);
        for(int i=a;i>=0;i--){
            for(int j=b;j<n;j++){
                if(arr[j]>=arr[i]){
                    m = Math.max(m,i+1+n-j);
                    break;
                }
            }
        }
        return n-m;
    }
}
// @lc code=end

