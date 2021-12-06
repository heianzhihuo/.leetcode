import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (55.56%)
 * Likes:    700
 * Dislikes: 0
 * Total Accepted:    114.6K
 * Total Submissions: 203.7K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 10^4] 内
 * -1000 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder ret = new StringBuilder();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        ret.append("[");
        ret.append(root.val);
        while(true){
            List<TreeNode> next = new ArrayList<>();
            StringBuilder tmp = new StringBuilder();
            for(TreeNode node:cur){
                tmp.append(",");
                if(node.left!=null){
                    next.add(node.left);
                    tmp.append(node.left.val);
                }else{
                    tmp.append("null");
                }
                tmp.append(",");
                if(node.right!=null){
                    next.add(node.right);
                    tmp.append(node.right.val);
                }else{
                    tmp.append("null");
                }
            }
            if(next.isEmpty()) break;
            ret.append(tmp);
            cur = next;
        }
        ret.append("]");
        return ret.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        String[] arr = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();// 队列
        queue.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode p = queue.getFirst();
            TreeNode node;
            if("null".equals(arr[i])){
                node = null;
            }else{
                node = new TreeNode(Integer.valueOf(arr[i]));
                queue.addLast(node);
            }
            if(i%2==1){
                p.left =  node;
            }else{
                p.right = node;
                queue.removeFirst();
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

