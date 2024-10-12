import java.util.*;

class Solution {
    
    public int dp (int[][] memo, int[][] triangle, int cur_i, int cur_j){
        
        memo[0][0] = triangle[0][0];
        if(memo[cur_i][cur_j] != 0){
           return memo[cur_i][cur_j];
        }else{
            if(cur_i > 0 && cur_i < triangle.length){
                if(cur_j == 0){
                    memo[cur_i][cur_j] = dp(memo,triangle,cur_i-1,0) + triangle[cur_i][0];
                }else if(cur_j == cur_i){
                    memo[cur_i][cur_j] = dp(memo,triangle,cur_i-1,cur_j-1) + triangle[cur_i][cur_j];
                }else{
                    memo[cur_i][cur_j] = Math.max(dp(memo,triangle,cur_i-1,cur_j-1),dp(memo,triangle,cur_i-1,cur_j)) + triangle[cur_i][cur_j];
                } 
            }
        }
        
        return memo[cur_i][cur_j];
    }
    
    public int solution(int[][] triangle) {
        int[][] memo = new int[triangle.length][triangle[triangle.length-1].length];
        int max = 0;
        
        for(int i=0; i < triangle[triangle.length-1].length; i++){
            if(max < dp(memo, triangle, triangle.length-1, i)){
                max = dp(memo, triangle, triangle.length-1, i);
            }
            
        }
        
        return max;
    }
}