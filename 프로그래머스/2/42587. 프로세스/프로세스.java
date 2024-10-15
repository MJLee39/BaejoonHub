import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue queue = new LinkedList<Integer>();
        Queue queueIndex = new LinkedList<Integer>();
        int order = 0;
        
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
            queueIndex.add(i);
        }
        
        while(!queue.isEmpty()){
            if(queue.peek() != Collections.max(queue)){
                int peek = (int)queue.remove();
                queue.add(peek);
                int peekIndex = (int)queueIndex.remove();
                queueIndex.add(peekIndex);
            }else{
                int out = (int)queue.remove();
                int outIndex = (int)queueIndex.remove();
                order++;
                if(outIndex == location){
                    answer = order;
                    break;
                }
            }
        }
        
        return answer;
    }
}