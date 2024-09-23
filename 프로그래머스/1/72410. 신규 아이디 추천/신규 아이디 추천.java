import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        new_id = new_id.toLowerCase();
        //2
        new_id = new_id.replaceAll("[~!@#$%^&*()=+{}:?,<>/]", "");
        new_id = new_id.replaceAll("\\[","");
        new_id = new_id.replaceAll("\\]","");
        //3
        new_id = new_id.replaceAll("[.]{2,}",".");
        //4
        if(new_id.charAt(0)=='.'){
            new_id = new_id.substring(1,new_id.length());
        }
        if(new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        //5
        if(new_id.length()==0){
            new_id = "a";
        }
        //6
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        //7
        while(new_id.length()<=2){
            String t = new_id.charAt(new_id.length()-1)+"";
            new_id = new_id+t;
        }
        
        answer = new_id;
        return answer;
    }
}