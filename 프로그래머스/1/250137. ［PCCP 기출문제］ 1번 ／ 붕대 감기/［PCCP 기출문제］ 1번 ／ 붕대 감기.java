import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int nowHealth = health;  //현재 체력
        int contin = 0; //연속 시간
        int time = bandage[0];
        int recover = bandage[1];
        int add = bandage[2];
        int index = 0; //현재 공격 인덱스
        
        for(int i = 0; i <= attacks[attacks.length-1][0]; i++){
            //i는 현재 시간
            if(i != attacks[index][0]){
                //공격 안 당한거
                contin++;
                if(nowHealth + recover <= health){
                    nowHealth = nowHealth + recover;
                }else{
                    nowHealth = health;
                }
                if(contin == time){
                    contin = 0;
                    if(nowHealth + add <= health){
                        nowHealth = nowHealth + add;
                    }else{
                        nowHealth = health;
                    }
                }
            }else{
                //공격 당함
                nowHealth -= attacks[index][1];
                contin = 0;
                index++;
                if(nowHealth <= 0){
                    return -1;
                }
            }
        }
        answer = nowHealth;
        return answer;
    }
}