import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char ans = ' ';
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0; i < skip.length(); i++){
            char sk = skip.charAt(i);
            list.add(sk);
        }
       
        for(int i=0; i<s.length();i++){
            int ind = index;
            char s_char = s.charAt(i);
            for(int j=1;j<=ind;j++){   //index만큼 반복
                if(s_char+j>122){
                    s_char = (char)(s_char-26);
                }
                if(list.contains((char)(s_char+j))){
                    ind++;                
                }
            }
            ans = (char)(s_char+ind);
            
            if(s_char+ind>122){
                //z초과일 때
                ans = (char)(s_char+ind-26);
            }
            answer += String.valueOf(ans);  
        }
        return answer;
    }
}