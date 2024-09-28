import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a:scoville){
            pq.add(a);
        }
        
        while(pq.size()>1 && pq.peek()<K){
            int first = pq.poll();
            
            int second = pq.poll();
            
            pq.add(first+(second*2));
            answer++;
        }
        if(pq.peek()<K){
            return -1;
        }
        return answer;
    }
}