import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int min = 0;
        int max = 0;
        Arrays.sort(citations);
        //System.out.println(Arrays.toString(citations));
        for(int i=0;i<citations.length;i++){
            if(citations[i]<=citations.length-i){
                min = citations[i];
            }else{
                min = citations.length-i;
            }
            if(min > max){
                max = min;
            }
        }
        
        //System.out.println("max: "+max);
        answer = max;
        return answer;
    }
}