import java.util.*;

class Solution {
    public int lcm(int a, int b){   //두 수의 최소공배수 구하는 함수
        int maxD = 1;
        for(int i=2; i<=a; i++){
            if(a%i==0 && b%i==0 && i>maxD){
                maxD = i;
            }
        }
        return maxD*(a/maxD)*(b/maxD);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int previous = lcm(arr[0],arr[1]);
        for(int j=2;j<arr.length;j++){
            previous = lcm(previous,arr[j]);
        }
        answer = previous;
        return answer;
    }
}