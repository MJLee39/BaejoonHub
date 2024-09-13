import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //hasp사용
        HashMap<String,Integer> compMap = new HashMap<>();
        for(int j=0;j<completion.length;j++){
            if(compMap.get(completion[j])==null){
                compMap.put(completion[j],1);
            }else{
                compMap.put(completion[j],compMap.get(completion[j])+1);
            }
        }
        HashMap<String,Integer> partMap = new HashMap<>();
        for(int j=0;j<participant.length;j++){
            if(partMap.get(participant[j])==null){
                partMap.put(participant[j],1);
            }else{
                partMap.put(participant[j],partMap.get(participant[j])+1);
            }
        }
        
        for(Map.Entry<String, Integer> part : partMap.entrySet()) {
            if(compMap.get(part.getKey())==null){
                answer = part.getKey();
                break;
            }else{
                if(part.getValue()>compMap.get(part.getKey())){
                    answer = part.getKey();
                    break;
                }
            }
        }
        
        //정확성은 맞지만 list를 사용해서 한번 탐색하는데 시간이 list.size()만큼 걸림
        // List<String> list = new ArrayList<>(Arrays.asList(participant));
        // for(int i=0;i<completion.length;i++){
        //     //System.out.println(list);
        //     if(list.contains(completion[i])){
        //         participant[list.indexOf(completion[i])] = "";
        //         list.set(list.indexOf(completion[i]),"");
        //     }
        // }
        // for(int j=0;j<participant.length;j++){
        //     if(!participant[j].equals("") ){
        //         answer=participant[j];
        //         break;
        //     }
        // }
        // System.out.println("participant[]: "+Arrays.toString(participant));
        return answer;
    }
}