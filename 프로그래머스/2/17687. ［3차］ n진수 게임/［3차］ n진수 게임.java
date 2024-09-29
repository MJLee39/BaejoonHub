import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<t*m;i++){
            String s = Integer.toString(i,n);
            String[] arrStr = s.split("");   
            for(int j=0;j<arrStr.length;j++){
                list.add(arrStr[j]);
            }
        }
        
        for(int k=p-1;k<t*m;k=k+m){
            answer+=list.get(k)+"";
            answer = answer.toUpperCase();
        }
        return answer;
    }
}