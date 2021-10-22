/*
 * @lc app=leetcode.cn id=488 lang=java
 *
 * [488] 祖玛游戏
 */

// @lc code=start
class Solution {
    int ret = -1;
    char[] chs = { 'R','Y','B','G','W'};
    public int findMinStep(String board, String hand) {
        int[] count = new int[5];
        for(int i=0;i<hand.length();i++){
            char ch = hand.charAt(i);
            if(ch=='R'){
                count[0]++;
            }else if(ch=='Y'){
                count[1]++;
            }else if(ch=='B'){
                count[2]++;
            }else if(ch=='G'){
                count[3]++;
            }else if(ch=='W'){
                count[4]++;
            }
        }
        findDFS(board,count,0);
        return ret;
    }

    public void findDFS(String board, int[] count,int c){
        // System.out.println(board+","+c);
        if(board.length()==0){
            if(ret==-1 || c<ret){
                ret = c;
            }
        }
        if(ret!=-1 && c>=ret){
            return;
        }
        for(int i=0;i<5;i++){
            if(count[i]>0){
                count[i]--;
                char ch = chs[i];
                for(int j=0;j<board.length();j++){
                    if(ch==board.charAt(j)){
                        String t1 = board.substring(0,j);
                        if(j<board.length()-1 && board.charAt(j+1)==ch){
                            String t2 = board.substring(j+2);
                            findDFS(t1+t2,count,c+1);
                        }else{
                            String t2 = board.substring(j);
                            findDFS(t1+ch+t2,count,c+1);
                        }
                    }
                }
                count[i]++;
            }
        }
    }
}
// @lc code=end

