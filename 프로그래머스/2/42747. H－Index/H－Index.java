import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int max = 0;
        Arrays.sort(citations);
        for(int i=n-1; i>=0; i--){
            if(n-i >= citations[i]){ 
                max = citations[i];
                break;
            }
        }
        if(n <= citations[0]){
            if(max < n){
                max = n;
            }
        }else{
            for(int i=0; i<n; i++){
                if(n-i <= citations[i]){
                    if(max < n-i){
                        max = n-i;
                    }
                    break;
                }
            }
        }
        return max;
    }
}