import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length;i++){
            map.put(players[i], i);
        }

        for(int j=0;j<callings.length;j++){
            //등수
            int grade = map.get(callings[j]);
            //앞지르기 당한 선수 이름
            String forwardCalling = players[grade - 1];
            //array에 앞지름 반영
            players[grade - 1] = callings[j];
            //map에 앞지름 반영
            map.put(callings[j], grade - 1);
            //array에 뒤처짐 반영
            players[grade] = forwardCalling;
            //map에 뒤처짐 반영
            map.put(forwardCalling, grade);
        }   

        for(String key : map.keySet()){
            answer[map.get(key)] = key;
        }
        return answer;
    }
}