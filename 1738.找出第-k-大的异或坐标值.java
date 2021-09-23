/*
 * @lc app=leetcode.cn id=1738 lang=java
 *
 * [1738] 找出第 K 大的异或坐标值
 */

// @lc code=start
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0){
                    matrix[i][j] ^= matrix[i-1][j];
                }
                if(j>0){
                    matrix[i][j] ^= matrix[i][j-1];
                }
                if(i>0 && j>0){
                    matrix[i][j] ^= matrix[i-1][j-1];
                }

                arr[n*i+j] = matrix[i][j];
            }
        }
        // for(int i=0;i<m*n;i++){
        //     System.out.println(arr[i]);
        // }
        Arrays.sort(arr);
        return arr[n*m-k];
    }
}
// @lc code=end

