import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        for(String[] cloth:clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
            //answer++;
        }
        List<Integer> valueList = new ArrayList<>(map.values());
        for(int i=0;i<valueList.size();i++){
            answer *= (valueList.get(i)+1);
        }
        answer -= 1;
        return answer;
    }
}