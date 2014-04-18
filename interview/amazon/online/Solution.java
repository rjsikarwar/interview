class Solution {
    private int amplitude = Math.MIN_VALUE;
    public int solution(Tree T) {
        // write your code in Java SE 7
        if(null == T){
            return 0;
        }
        helper(T, 0, 0);
        return amplitude;
    }
    
    private void helper(Tree T, int min, int max){
        if(T.x < min){
            min = T.x;
        }
        if(T.x > max){
            max = T.x;
        }
        if(T.l == null && T.r == null){
            amplitude = Math.max(amplitude, max - min);
        }
        if(T.l != null){
            helper(T.l, min, max);
        }
        if(T.l != null){
            helper(T.r, min, max);
        }
    }
}
