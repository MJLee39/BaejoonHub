import java.util.*;

class Solution {
    public boolean isPrime(long n){
        boolean t = true;
        if(n==1){
            return false;
        }
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                t = false;
            }
        }
        return t;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String strNum = Integer.toString(n,k);
        String[] arr = strNum.split("0");
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("") && isPrime(Long.valueOf(arr[i]))){
                answer++;
            }
        }
        
        return answer;
    }
}