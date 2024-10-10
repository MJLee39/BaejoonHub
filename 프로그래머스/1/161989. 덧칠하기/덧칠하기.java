import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        List<Integer> intList = new ArrayList<>();
        for (int element : section) {
            intList.add(element);
        }
        //System.out.print("처음: "+intList);
        
        for(int i=0; i<section.length; i++){
            //안 칠해진 벽만 체크
            if(intList.contains(section[i])){
                for(int j=section[i]; j<=section[i]+m-1; j++){
                    intList.remove(Integer.valueOf(j));
                }
                answer++;
                //System.out.print(", answer: "+answer);
                if(intList.size()==0){
                    break;
                }
            }
        }
        //System.out.print(", 나중: "+intList);
        return answer;
    }
}