/*
 * @lc app=leetcode.cn id=1960 lang=java
 *
 * [1960] 两个回文子字符串长度的最大乘积
 */

// @lc code=start
class Solution {
    public long maxProduct(String s) {
        int n = s.length();
        int[] par = new int[n];// 表示从i开始
        int c = -1,r = -1;// 中心，右展
        // 马拉车算法
        for(int i=0;i<n;i++){
            if(r>i){
                par[i] = Math.min(r-i,par[2*c-i]);
            }else{
                par[i] = 1;
            }
            while(i-par[i]>=0 && i+par[i]<n && s.charAt(i-par[i]) == s.charAt(i+par[i])){
                par[i]++;
            }
            if(i+par[i]>r){
                r = i+par[i];
                c = i;
            }
        }
        int[] left = new int[n];// 表示小于等于i的最大
        left[0] = 1;
        int p = 0;
        for(int i=1;i<n;i++){
            while(p+par[p]-1<i) p++;
            left[i] = Math.max(left[i-1],i-p+1);
        }
        int[] right = new int[n];
        right[n-1] = 1;
        p = n-1;
        for(int i=n-2;i>=0;i--){
            while(p-par[p]+1>i) p--;
            right[i] = Math.max(right[i+1],p-i+1);
        }
        long res = 1;
        for(int i=1;i<n;i++){
            res = Math.max(res,(long)(left[i-1]*2-1)*(long)(right[i]*2-1));
        }
        return res;
    }
}
// @lc code=end

