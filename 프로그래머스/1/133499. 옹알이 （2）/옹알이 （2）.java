import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0;i<babbling.length;i++){
            if(babbling[i].contains("ayaaya")||babbling[i].contains("yeye")||babbling[i].contains("woowoo")||babbling[i].contains("mama")){
                //같은 발음 연속해서 발음하면 안 됨
                continue;
            }else{
                String[] alpa = babbling[i].split("aya|ye|woo|ma");
                //System.out.print(Arrays.toString(alpa));
                if(alpa.length==0){
                    answer++;
                }
            }
        }
        return answer;
    }
}