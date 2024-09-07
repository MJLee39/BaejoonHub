import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int min = 1000000000;
        int sum = sequence[start];
        int len = sequence.length;
        
        //앞에서부터 시작하므로 길이가 짧은 수열이 여러개인 경우 앞쪽에 나오는 수 만족
        while(end < len){
            if(sum == k){  //같으면 최적인지 확인
                if((end-start) < min){
                    min = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
                if(end < len){
                    sum += sequence[end];
                }
            }else if(sum < k){
                end++;
                if(end < len){
                    sum += sequence[end];
                }
            }else{
                sum -= sequence[start];
                start++;
            }
        }
        
        
        return answer;
    }
}