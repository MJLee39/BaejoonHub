import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int ans = 0;  //맞은 개수
        int zero = 0; //모르는 수 개수
        // int[] -> List
        List<Integer> lottosList = new ArrayList<>();
        for (int lotto : lottos) {
            lottosList.add(lotto);
        }
        // int[] -> List
        List<Integer> win_numsList = new ArrayList<>();
        for (int win : win_nums) {
            win_numsList.add(win);
        }
        for(int win:win_nums){
            if(lottosList.contains(win)){
                //System.out.println("yes");
                ans++;
            }
        }
        for(int lot:lottos){
            if(lot==0){
                zero++;
            }
        }
        
        if(ans+zero==6){
            answer[0]=1;
        }else if(ans+zero==5){
            answer[0]=2;
        }else if(ans+zero==4){
            answer[0]=3;
        }else if(ans+zero==3){
            answer[0]=4;
        }else if(ans+zero==2){
            answer[0]=5;
        }else if(ans+zero<=1){
            answer[0]=6;
        }
        
        if(ans==6){
            answer[1]=1;
        }else if(ans==5){
            answer[1]=2;
        }else if(ans==4){
            answer[1]=3;
        }else if(ans==3){
            answer[1]=4;
        }else if(ans==2){
            answer[1]=5;
        }else if(ans<=1){
            answer[1]=6;
        }
        
        
        //System.out.println(lottosList.contains(44));
        //System.out.println(zero);
        return answer;
    }
}