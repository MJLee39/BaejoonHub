import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String temp = "";
        int again = strings.length*(strings.length-1)/2;
        //System.out.println("again:"+again);
        while(again>0){
            for(int j=0;j<again;j++){
                for(int i=0; i<strings.length-1; i++){
                    if(strings[i].charAt(n) > strings[i+1].charAt(n)){
                        temp = strings[i];
                        strings[i] = strings[i+1];
                        strings[i+1] = temp;
                    }else if(strings[i].charAt(n) == strings[i+1].charAt(n)){
                        //System.out.println("여기옴");
                        List<String> list = Arrays.asList(strings[i],strings[i+1]);
                        Collections.sort(list);
                        strings[i] = list.get(0);
                        strings[i+1] = list.get(1);
                    }
                }
            }
            again -= 1;
        }
        answer = strings;
        //System.out.println(Arrays.toString(strings));
        return answer;
    }
}