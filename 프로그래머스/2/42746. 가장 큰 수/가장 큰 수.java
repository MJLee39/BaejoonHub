import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Arrays.sort(numbers);
        
        if(numbers[numbers.length-1] == 0){
            return 0+"";
        }else{
            // int 배열을 Integer 배열로 변환
            String[] Strings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
            Arrays.sort(Strings, new Comparator<String>(){
                @Override
                public int compare(String a, String b){
                    return (b + a).compareTo(a + b);
                }
            });
            
            StringBuilder sb = new StringBuilder();
            for(String str : Strings){
                sb.append(str);
            }
            answer = sb.toString();
            return answer;
        }
    }
}