import java.util.*;

class Solution {
    public int[] x_move = {-1, 0, 1, 0};
    public int[] y_move = {0, 1, 0, -1};
    
    public int whenAri(int[][] maps){
        int cur_x = 0;
        int cur_y = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int ans = bfs(cur_x, cur_y, maps, visited);
        
        return ans;
    }
    
    public int bfs(int cur_x, int cur_y, int[][] maps, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{cur_x, cur_y, 1});
        visited[cur_x][cur_y] = true;
        
        while(!queue.isEmpty()){
            int[] thisArr = queue.poll();
            int this_x = thisArr[0];
            int this_y = thisArr[1];
            int len = thisArr[2];
            for(int i=0; i<4; i++){
                int next_x = this_x + x_move[i];
                int next_y = this_y + y_move[i];
                if(next_x < 0 || next_x >= maps.length || next_y < 0 || next_y >= maps[0].length || visited[next_x][next_y] || maps[next_x][next_y] == 0){
                    continue;
                }

                if(next_x == maps.length-1 && next_y == maps[0].length-1){
                    //End
                    return len+1;
                }
                queue.add(new int[]{next_x, next_y, len+1});
                visited[next_x][next_y] = true;
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        if(maps.length == 1){
            for(int i=0; i<maps[0].length; i++){
                if(maps[0][i] == 1){
                    answer++;
                }else{
                    return -1;
                }
            }
        }else if(maps[0].length == 1){
            for(int i=0; i<maps.length; i++){
                if(maps[i][0] == 1){
                    answer++;
                }else{
                    return -1;
                }
            }
        }else{
            answer = whenAri(maps);
        }
        
        return answer;
    }
}