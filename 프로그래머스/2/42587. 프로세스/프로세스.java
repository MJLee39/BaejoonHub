import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<priorities.length;i++){
            q.offer(priorities[i]);
        }
        int currentLoca = location;
        while(!q.isEmpty()){
            //System.out.println("max: "+Collections.max(q));
            if(q.peek()==Collections.max(q)){
                answer++;
                if(currentLoca!=0){
                    currentLoca = currentLoca-1;
                }else{
                    break;
                }
                q.poll();
                //System.out.println(q);
            }else{
                q.offer(q.poll());
                if(currentLoca==0){
                    currentLoca = q.size()-1;
                }else{
                    currentLoca = currentLoca-1;
                }
                //System.out.println(q);
            }
        }
        
        return answer;
    }
}