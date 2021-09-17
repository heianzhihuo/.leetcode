/*
 * @lc app=leetcode.cn id=936 lang=java
 *
 * [936] 戳印序列
 */

// @lc code=start
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        // "lemk"\n"lleme"\n
        List<Integer> res = new ArrayList<>();
        int m = stamp.length();
        int n = target.length();
        boolean[] visited = new boolean[n];
        int count = 0,last = 1;
        while(last!=count){
            // System.out.println(count);
            last = count;
            for(int i=0;i<n-m+1;i++){
                boolean flag = true;
                boolean flag2 = false;
                for(int j=0;j<m;j++){
                    if(!visited[i+j]){
                        flag2 = true;
                        if(stamp.charAt(j)!=target.charAt(i+j)){
                            flag = false;
                            break;
                        }
                    }
                }
                // System.out.println(flag+","+flag2+","+i);
                if(flag && flag2){
                    res.add(i);
                    for(int j=0;j<m;j++){
                        if(!visited[i+j]){
                            visited[i+j] = true;
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
        if(count!=n){
            return new int[0];
        }
        int[] ret = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(res.size()-i-1);
        }
        return ret;
    }
}
// @lc code=end

