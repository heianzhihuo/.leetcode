/*
 * @lc app=leetcode.cn id=1286 lang=java
 *
 * [1286] 字母组合迭代器
 */

// @lc code=start
class CombinationIterator {

    List<List<Integer>>[][] map;

    public void combination(int n,int m){
        if(map[n][m]!=null){
            return;// 
        }
        List<List<Integer>> ret = new ArrayList<>();
        if(m==0){
            ret.add(new ArrayList<>());
        }else if(n==1 && m==1){
            ret.add(Arrays.asList(0));    
        }else if(n==m){
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<n;i++){
                tmp.add(i);
            }
            ret.add(tmp);
        }else{
            combination(n-1,m-1);
            combination(n-1,m);
            List<List<Integer>> subret1 = map[n-1][m-1];
            for(List<Integer> subsol:subret1){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                for(int x:subsol){
                    tmp.add(x+1);
                }
                ret.add(tmp);
            }
            List<List<Integer>> subret2 = map[n-1][m];
            for(List<Integer> subsol:subret2){
                List<Integer> tmp = new ArrayList<>();
                for(int x:subsol){
                    tmp.add(x+1);
                }
                ret.add(tmp);
            }
        }
        map[n][m] = ret;
    }

    List<List<Integer>> data;
    int cur;
    String str;
    public CombinationIterator(String characters, int combinationLength) {
        cur = 0;
        str = characters;
        int n = str.length();
        int m = combinationLength;
        map = new List[n+1][m+1];
        combination(n,m);
        data = map[n][m];
    }
    
    public String next() {
        List<Integer> tmp = data.get(cur);
        cur++;
        StringBuilder sb = new StringBuilder();
        for(int x:tmp){
            sb.append(str.charAt(x));
        }
        return sb.toString();
    }
    
    public boolean hasNext() {
        return cur<data.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

