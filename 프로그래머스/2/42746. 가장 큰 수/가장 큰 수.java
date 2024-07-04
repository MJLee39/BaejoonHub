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
            Arrays.sort(Strings, (a, b) -> (b + a).compareTo(a + b));
//             Arrays.sort(Strings, new Comparator<String>(){
//                 @Override
//                 public int compare(String a, String b){
//                     int a_len = a.length();
//                     int b_len = b.length();
//                     if(Integer.parseInt(b.substring(0,1)) == Integer.parseInt(a.substring(0,1))){
//                         if(a_len == b_len){
//                             return Integer.parseInt(b) - Integer.parseInt(a);
//                         }else{
//                             if(a_len > b_len){
//                                 if(Integer.parseInt(a.substring(0,1)) < Integer.parseInt(a.substring(1,2))){
//                                     for(int i=1; i<=b_len; i++){
//                                         if(Integer.parseInt(a.substring(0,i)) < Integer.parseInt(b.substring(0,i))){
//                                             // 344, 37
//                                             return 1;
//                                         }else if(Integer.parseInt(a.substring(0,i)) > Integer.parseInt(b.substring(0,i))){
//                                             // 371, 31
//                                             return -1;
//                                         }
//                                     }
//                                     // 37, 3
//                                     return -1;
//                                 }else if(Integer.parseInt(a.substring(0,1)) == Integer.parseInt(a.substring(1,2))){
//                                     for(int i=1; i<=b_len; i++){
//                                         if(Integer.parseInt(a.substring(0,i)) < Integer.parseInt(b.substring(0,i))){
//                                             // 333, 37
//                                             return 1;
//                                         }else if(Integer.parseInt(a.substring(0,i)) > Integer.parseInt(b.substring(0,i))){
//                                             // 333, 31
//                                             return -1;
//                                         }
//                                     }
//                                     // 333, 33
//                                     return 1;
//                                 }else{
//                                     // 32, 3
//                                     return 1;
//                                 }
//                             }else{
//                                 // a_len < b_len
//                                 if(Integer.parseInt(b.substring(0,1)) < Integer.parseInt(b.substring(1,2))){
//                                     for(int i=1; i<=a_len; i++){
//                                         if(Integer.parseInt(b.substring(0,i)) < Integer.parseInt(a.substring(0,i))){
//                                             // 37, 344
//                                             return -1;
//                                         }else if(Integer.parseInt(b.substring(0,i)) > Integer.parseInt(a.substring(0,i))){
//                                             // 31, 371
//                                             return 1;
//                                         }
//                                     }
//                                     // 3, 37
//                                     return 1;
//                                 }else if(Integer.parseInt(b.substring(0,1)) == Integer.parseInt(b.substring(1,2))){
//                                     for(int i=1; i<=a_len; i++){
//                                         if(Integer.parseInt(b.substring(0,i)) < Integer.parseInt(a.substring(0,i))){
//                                             // 37, 333
//                                             return -1;
//                                         }else if(Integer.parseInt(b.substring(0,i)) > Integer.parseInt(a.substring(0,i))){
//                                             // 31, 333
//                                             return 1;
//                                         }
//                                     }
//                                     // 33, 333
//                                     return -1;
//                                 }else{
//                                     // 3, 32
//                                     return -1;
//                                 }
//                             }
//                         }
//                     }

//                     return Integer.parseInt(b.substring(0,1)) - Integer.parseInt(a.substring(0,1));
//                 }
//             });

            StringBuilder sb = new StringBuilder();
            for(String str : Strings){
                sb.append(str);
            }
            answer = sb.toString();
            return answer;
        }
    }
}