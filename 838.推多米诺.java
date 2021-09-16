/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] res = new char[n];
        for(int i=0;i<n;i++){
            res[i] = '.';
        }
        int curR = -1;
        int curL = -1;
        boolean rFlag = false;
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='L'){
                int m;
                if(rFlag){
                    m = (i-curR)/2+curR;
                    if((i-curR)%2==0){
                        res[m] = '.';
                    }
                }else{
                    m = curL;
                }
                for(int j=i;j>m;j--){
                    res[j] = 'L';
                }
                curR = -1;
                rFlag = false;
                curL = i;
            }else if(dominoes.charAt(i)=='R'){
                rFlag = true;
                curR = i;
            }
            if(rFlag){
                res[i] = 'R';
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

