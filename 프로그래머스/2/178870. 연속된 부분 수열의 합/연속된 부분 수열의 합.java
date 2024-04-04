import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int min = 1000000000;
        int sum = sequence[start];
        
        for(int i=0; i<sequence.length; i++){
            while(end < sequence.length){
                if(sum == k){
                    if((end-start) < min){
                        min = end - start;
                        answer[0] = start;
                        answer[1] = end;
                    }
                    end++;
                    if(end < sequence.length){
                        sum += sequence[end];
                    }
                }else if(sum < k){
                    end++;
                    if(end < sequence.length){
                        sum += sequence[end];
                    }
                }else{
                    sum -= sequence[start];
                    start++;
                }
            }
        }   
        
        return answer;
    }
}