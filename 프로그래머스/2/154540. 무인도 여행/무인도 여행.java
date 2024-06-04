import java.util.*;

class Solution {
    public int[] x_move = {-1, 0, 1, 0};
    public int[] y_move = {0, 1, 0, -1};
    
    public ArrayList<Integer> numOfIsland(int[][] map){
        int num = 0;
        ArrayList<Integer> ansArr = new ArrayList<Integer>();
        int[][] visited = new int[map.length][map[0].length];
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] > 0 && visited[i][j] == 0){
                    //땅이고 방문 안했으면
                    int ans = bfs(i, j, map, visited);
                    ansArr.add(ans);
                }
            }
        }
        return ansArr;
    }
    
    public int bfs(int cur_x, int cur_y, int[][] map, int[][] visited){
        int ans = 0;
        ans += map[cur_x][cur_y];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{cur_x, cur_y});
        visited[cur_x][cur_y] = -1;

        while(!queue.isEmpty()){
            int[] cur_queue = queue.poll();
            int this_x = cur_queue[0];
            int this_y = cur_queue[1];
            
            for(int k=0; k < 4; k++){
                int next_x = this_x + x_move[k];
                int next_y = this_y + y_move[k];
                
                if(next_x < 0 || next_x >= map.length || next_y < 0 || next_y >= map[0].length || map[next_x][next_y] == 0 || visited[next_x][next_y] == -1){
                    continue;
                }
                
                ans += map[next_x][next_y];
                queue.add(new int[]{next_x, next_y});
                visited[next_x][next_y] = -1;
            }
        }
        return ans;
    }
    
    public ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[][] map = new int[maps.length][maps[0].length()];
        boolean flag = true;
        
        for(int i=0; i<maps.length; i++){
            String[] str = maps[i].split("");
            for(int j=0; j<str.length; j++){
                if(!str[j].equals("X")){
                    map[i][j] = Integer.parseInt(str[j]);
                    flag = false;
                }
            }
        }
        if(flag){
            answer.add(-1);
        }else{
            answer = numOfIsland(map);
            Collections.sort(answer);
        }
        return answer;
    }
}