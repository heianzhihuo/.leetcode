/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {

    double r;
    double x0;
    double y0;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x0 = x_center;
        y0 = y_center;
    }
    
    public double[] randPoint() {
        double[] res = new double[2];
        double angle = Math.random()*2*Math.PI;
        double rad = Math.sqrt(Math.random()*r*r);
        res[0] = x0+Math.cos(angle)*rad;
        res[1] = y0+Math.sin(angle)*rad;
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

