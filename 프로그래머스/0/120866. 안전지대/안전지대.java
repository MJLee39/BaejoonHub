class Solution {
    
    public int[] x_move = {0,0,1,1,1,-1,-1,-1};
    public int[] y_move = {1,-1,0,1,-1,0,1,-1};
    
    public void dfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;
        for(int i=0; i<8; i++){
            int next_x = x + x_move[i];
            int next_y = y + y_move[i];
            if(next_x >= 0 && next_x < visited.length && next_y >= 0 && next_y < visited.length){
                if(!visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board.length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1){
                    //dfs 통해서 방문 표시
                    dfs(i,j,visited);
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(!visited[i][j]){
                    answer++;
                }
            }
        }
        return answer;
    }
}