import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> map = new HashMap<>();  //<신고된 ID, 신고 횟수>
        List<String> keyList = new ArrayList<String>();  //정지된 ID
        HashMap<String, Integer> ansMap = new HashMap<>();  //id별로 받은 결과 메일 수
        
        //report 중복 제거
        String[] reportArr = Arrays.stream(report).distinct().toArray(String[]::new);
        
        //신고당한 ID map에 담기
        for(String rep:reportArr){
            map.put(rep.substring(rep.indexOf(" ")+1,rep.length()), map.getOrDefault(rep.substring(rep.indexOf(" ")+1,rep.length()), 0) + 1);
        }
        
        //map에 담긴 아이디 중 k보다 많이 신고된 아이디 찾기
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()>=k ){
              keyList.add(entry.getKey());
            }
        }
        
        //<id, 정지메일을 받는 개수> map에 담기
        for(String rep:reportArr){
            if(keyList.contains(rep.substring(rep.indexOf(" ")+1,rep.length()))){
                ansMap.put(rep.substring(0,rep.indexOf(" ")), ansMap.getOrDefault(rep.substring(0,rep.indexOf(" ")), 0) + 1);
            }
        }
        
        //answer에 담기
        for(int i=0;i<id_list.length;i++){
            if(ansMap.get(id_list[i])==null){
                answer[i]=0;
            }else{
                answer[i]= ansMap.get(id_list[i]);
            }
        }
        return answer;
    }
}