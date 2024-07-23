import java.util.*;

class Solution {
    
    public int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdNum = 0;  //최대공약수
        int gcdNumB = 0; //최대공약수
       
        if(arrayA.length >= 2){
            gcdNum = gcd(arrayA[0], arrayA[1]);
            for(int i = 2; i < arrayA.length; i++){
                gcdNum = gcd(gcdNum, arrayA[i]);
            }
        }else{
            //arrayA.length = 1
            gcdNum = arrayA[0];
        }
        
        for(int i = 0; i < arrayB.length; i++){
            if(arrayB[i] % gcdNum == 0){
                gcdNum = 0;
                break;
            }
        }
        
        if(arrayB.length >= 2){
            gcdNumB = gcd(arrayB[0], arrayB[1]);
            for(int i = 2; i < arrayB.length; i++){
                gcdNumB = gcd(gcdNumB, arrayB[i]);
            }
        }else{
            //arrayA.length = 1
            gcdNumB = arrayB[0];
        }
        
        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] % gcdNumB == 0){
                gcdNumB = 0;
                break;
            }
        }
    
        answer = Math.max(gcdNum, gcdNumB);

        return answer;
    }
}