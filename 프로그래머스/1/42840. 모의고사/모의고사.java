import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<Integer> list = new ArrayList<>();
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int a_ans = 0;
        int b_ans = 0;
        int c_ans = 0;
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==(i%5+1)){
                //a랑 일치
                a_ans++;
            }
            if(answers[i]==b[i%8]){
                //b랑 일치
                b_ans++;
            }
            if(answers[i]==c[i%10]){
                //c랑 일치
                c_ans++;
            }
            
        }
        System.out.println("a: "+a_ans+",b: "+b_ans+",c: "+c_ans);

        if(Math.max(Math.max(a_ans,b_ans),c_ans)==a_ans){
            list.add(1);
        }
        if(Math.max(Math.max(a_ans,b_ans),c_ans)==b_ans){
            list.add(2);
        }
        if(Math.max(Math.max(a_ans,b_ans),c_ans)==c_ans){
            list.add(3);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}