import java.util.*;

class Solution {
    
    public int dfs(int[] numbers, int target, int index, int curr){
        if(index == numbers.length){
            return curr == target ? 1:0;
        }
        
        int add = dfs(numbers, target, index+1, curr+numbers[index]);
        int minus = dfs(numbers, target, index+1, curr-numbers[index]);
        return add+minus;
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
}