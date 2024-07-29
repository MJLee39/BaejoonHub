import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int canDo = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> lostList = new ArrayList<>();
    
        for (int lo : lost) {
            lostList.add(lo);
        }
        
        for(int j=0;j<reserve.length;j++){
            if(lostList.contains(reserve[j])) {
                canDo++;
                lost[lostList.indexOf(reserve[j])]=-1;
                reserve[j]=-3;
            }
        }    
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1){
                    canDo++;
                    lost[i]=-1;
                    reserve[j]=-3;
                    break;
                }
            }
        }
        answer = answer+canDo;
       
        return answer;
    }
}