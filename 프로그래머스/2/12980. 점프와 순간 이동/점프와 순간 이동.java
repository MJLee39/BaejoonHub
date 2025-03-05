import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if(n%2 == 0){
                n /= 2;
            }else{
                n--;
                ans++;
            }
        }
        //효율성 테스트 1,4번 실패
        // int max = 0; 
        // while(n>=1){
        //     for(int i=0; i<=(int)Math.sqrt(n)+1;i++){
        //         if(n<Math.pow(2,i)){
        //             max = i-1;
        //             break;
        //         }else if(n==Math.pow(2,i)){
        //             max = i;
        //             break;
        //         }
        //     }
        //     n -= Math.pow(2,max);
        //     ans++;
        // }
        return ans;
    }
}