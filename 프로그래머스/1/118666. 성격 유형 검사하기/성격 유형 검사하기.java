import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        for(int i=0;i<survey.length;i++){
            if(1<=choices[i] && choices[i]<=3){
                //비동의
                map.put(survey[i].substring(0,1),4-choices[i]+map.get(survey[i].substring(0,1)));
            }else if(5<=choices[i] && choices[i]<=7){
                //동의
                map.put(survey[i].substring(1,2),map.get(survey[i].substring(1,2))+choices[i]-4);
            }
        }
        if(map.get("R") < map.get("T")){
            answer += "T";
        }else{
            answer += "R";
        }
        if(map.get("C") < map.get("F")){
            answer += "F";
        }else{
            answer += "C";
        }
        if(map.get("J") < map.get("M")){
            answer += "M";
        }else{
            answer += "J";
        }
        if(map.get("A") < map.get("N")){
            answer += "N";
        }else{
            answer += "A";
        }
        //System.out.println(map);
        return answer;
    }
}