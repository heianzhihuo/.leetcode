import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1172 lang=java
 *
 * [1172] 餐盘栈
 *
 * https://leetcode-cn.com/problems/dinner-plate-stacks/description/
 *
 * algorithms
 * Hard (27.38%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    2.6K
 * Total Submissions: 9.9K
 * Testcase Example:  '["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]\n' +
  '[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]'
 *
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * 
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * 
 * 
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回
 * -1。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入： 
 * 
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * 
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 * 1  3  5
 * ⁠                                   ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 * ⁠                                         1  3  5
 * ⁠                                         ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 * 1  3  5
 * ⁠                                  ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 * 1  3  5
 * ⁠                                  ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 * ⁠                                           1  3  5
 * ⁠                                           ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 * ⁠                                           1  3  5
 * ⁠                                           ﹈ ﹈ ﹈ 
 * D.pop()            // 返回 5。栈的现状为：        4
 * ⁠                                           1  3 
 * ⁠                                           ﹈ ﹈  
 * D.pop()            // 返回 4。栈的现状为：    1  3 
 * ⁠                                          ﹈ ﹈   
 * D.pop()            // 返回 3。栈的现状为：    1 
 * ⁠                                          ﹈   
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 * 
 * 
 */

// @lc code=start
import java.util.*;
class DinnerPlates {

    /**
     * 实现思路有很多种方法：
     * 方法一：数组+栈，push O(n/cap) pop() O(n/cap) popAt() O(index)
     * 
     * 方法二：数组+两个堆，创建一个100000的Stack数组
     * 堆1最小堆，当前没有满的栈的索引
     * 堆2最大堆，当前不为空的栈的索引
     */
    List<Stack<Integer>> data;
    int left,right,capacity;// 最左非满栈，最右非空栈，容量
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
        data.add(new Stack<>());
        left = 0;
        right = 0;
    }
    
    public void push(int val) {
        Stack<Integer> stack = data.get(left);
        stack.push(val);
        int i = left;
        if(stack.size()==capacity){
            for(;i<=right;i++){
                if(data.get(i).size()<capacity) break;
            }
        }
        if(i<=right){
            left = i;
        }else{
            if(i>=data.size()){
                data.add(new Stack<>());
            }
            left = i;
            right++;
        }
    }
    
    public int pop() {
        int ret = -1;
        

        return ret;
    }
    
    public int popAtStack(int index) {

    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
// @lc code=end

