/*
 * @lc app=leetcode.cn id=1927 lang=java
 *
 * [1927] 求和游戏
 */

// @lc code=start
class Solution {

    public boolean sumGame(String num) {
        int n = num.length();
        int x0=0,x1=0;// 左边的问号数，右边问号数
        int y0=0,y1=0;// 左边和，右边和
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            if(ch=='?'){
                if(i<n/2){
                    x0++;
                }else{
                    x1++;
                }
            }else{
                if(i<n/2){
                    y0 += ch-'0';
                }else{
                    y1 += ch-'0';
                }
            }
        }
        System.out.println(x0+","+x1+","+y0+","+y1);
        if(y0==y1){
            // 左侧和等于右侧和，
            // Alice获胜当且仅当左侧问号数不等于右侧问号数
            return x0!=x1;
        }
        if(x0==x1){
            // 左侧问号数等于右侧问号数
            // Alice获胜，当且仅当左侧和不等于右侧和
            return y0!=y1;
        }
        // 都不想等
        if((x0+x1)%2==1){
            return true;// 问号数为奇数，则Alice获胜
        }
        if((x0-x1)*(y0-y1)>0){
            return true;//左侧问号多且左侧和大，或，右侧问号多且右侧和大
        }
        int a0 = y0+((x0+1)/2)*9+(x0/2);// Alice先在左侧填9
        int a1 = y1+((x1+1)/2)*9+(x1/2);// 
        System.out.println(a0+","+a1);
        if(a0>a1){
            return true;
        }
        // 先在左侧填1
        int b0 = y0+(x0/2)*9+((x0+1)/2);
        int b1 = y1+(x1/2)*9+((x1+1)/2);//
        System.out.println(b0+","+b1);
        if(b1>b0){
            return true;
        }
        return false;
    }
}
// @lc code=end

