/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> data;
    public NestedIterator(List<NestedInteger> nestedList) {
        data = new LinkedList<>();
        for(NestedInteger nest:nestedList){
            data.addAll(parse(nest));
        }
    }

    public LinkedList<Integer> parse(NestedInteger root){
        LinkedList<Integer> ret = new LinkedList<>();
        if(root.isInteger()){
            ret.add(root.getInteger());
        }else{
            for(NestedInteger tmp:root.getList()){
                ret.addAll(parse(tmp));
            }
        }
        return ret;
    }

    @Override
    public Integer next() {
        Integer ret =data.getFirst();
        data.removeFirst();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return data.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

