import java.util.Map;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (33.35%)
 * Likes:    361
 * Dislikes: 0
 * Total Accepted:    50K
 * Total Submissions: 143.7K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * points[i].length == 2
 * -10^4 i, yi 
 * points 中的所有点 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {

    public int gcd(int a,int b){
        
    }

    public int maxPoints(int[][] points) {
        // y = kx + b
        // 只需要根据k和b确定直线即可
        Map<Node,Integer> cnt = new HashMap<>();
        int ret = 0;
        for(int i=0;i<points.length;i++){
            int x1 = points[i][0],y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                int x2 = points[j][0],y2 = points[j][1];
                Double k,b;
                if(x1==x2){
                    k = null;
                    b = x1*1.0;
                }else{
                    k = (y2-y1)*1.0/(x2-x1);
                    b = y1-k*x1;
                }
                Node node = new Node(k,b);
                int tmp = cnt.getOrDefault(node, 0)+1;
                ret = Math.max(tmp,ret);
                cnt.put(node,tmp);
            }
        }
        return (int)Math.sqrt(ret*2)+1;
    }
}
// @lc code=end

