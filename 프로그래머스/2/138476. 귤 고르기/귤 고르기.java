import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key : tangerine){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> entryList = new ArrayList<>(map.keySet());
        Collections.sort(entryList, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        
        for(int i=0;i<entryList.size();i++){
            if(k>0){
                k = k-map.get(entryList.get(i));
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}