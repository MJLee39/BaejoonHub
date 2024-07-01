import java.util.*;

class Solution {
    
    public int bfs(int n, int[][] computers, boolean[] used, int start){
        int ans = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        used[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<n; i++){
                if(cur != i && computers[cur][i] == 1 && !used[i]){
                    used[i] = true;
                    queue.offer(i);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(!used[i]){
                ans += bfs(n, computers, used, i);
            }
        }
        return ans;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] used = new boolean[n];
        answer = bfs(n, computers, used, 0);
        return answer;
    }
}