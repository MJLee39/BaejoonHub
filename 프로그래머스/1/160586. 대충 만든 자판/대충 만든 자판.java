import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String key : keymap){
            for(int i=0;i<key.length();i++){
                if(map.getOrDefault(key.substring(i,i+1),i)>i){
                    map.put(key.substring(i,i+1), i);
                }else{
                    map.put(key.substring(i,i+1), map.getOrDefault(key.substring(i,i+1), i));
                }
            }
        }
        
        System.out.println("결과 : " + map);
        
        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                //System.out.print(targets[i].substring(j,j+1)+": ");
                if(map.get(targets[i].substring(j,j+1))==null){
                    answer[i] = -1;
                    break;
                }else{
                    //System.out.println(map.get(targets[i].substring(j,j+1))+1);
                    answer[i] += map.get(targets[i].substring(j,j+1))+1;
                }
                
               
            }
        }
        return answer;
    }
}