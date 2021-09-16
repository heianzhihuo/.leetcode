/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int ret = 0;
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int a,s;
        a = 0;
        s = 1;
        for(int i=0;i<=n;i++){
            if(i==n || nums[i]==0){
                if(s>ret && i>a){
                    ret = s;
                }else if(-s>ret && i-a>=2){
                    int b = a;
                    int s1 = 1;
                    while(b<i && nums[b]>0) {
                        s1 *= nums[b];
                        b++;
                    }
                    int c = i-1;
                    int s2 = 1;
                    while(c>=a && nums[c]>0){
                        s2 *= nums[c];
                        c--;
                    }
                        ret = Math.max(s/s1/nums[b],ret);
                        ret = Math.max(s/s2/nums[c],ret);
                }

                a = i+1;
                s = 1;
            }else{
                s *= nums[i];
            }
        }
        return ret;
    }
}
// @lc code=end

