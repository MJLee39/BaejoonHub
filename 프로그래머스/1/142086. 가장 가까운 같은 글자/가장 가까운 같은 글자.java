import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] arr = new String[s.length()];
        arr = s.split("");
        answer[0] = -1;
        for(int i=1; i<arr.length;i++){
            //System.out.print((s.substring(0,i)).indexOf(arr[i])+", ");
            if((s.substring(0,i)).indexOf(arr[i])==-1){
                answer[i] = -1;
            }else if(arr[i].equals(arr[i-1])){
                answer[i] = 1;
            }else{
                //System.out.println("맞나"+s.substring((s.substring(0,i)).indexOf(arr[i])+1,i).indexOf(arr[i]));
                answer[i] = i - s.substring(0,i).lastIndexOf(arr[i]);
            }
        }
        
        //System.out.print(Arrays.toString(arr));
        return answer;
    }
}