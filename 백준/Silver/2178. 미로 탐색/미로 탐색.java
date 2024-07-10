import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] x_move = {1,0,0,-1};
	public static int[] y_move = {0,1,-1,0};
	
	public static int bfs(int[][] maze, int curX, int curY) {
		int ans = 1;
		int n = maze.length;
		int m = maze[0].length;
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {curX, curY, ans});
		visited[curX][curY] = true;
		
		while(!queue.isEmpty()) {
			int[] curList = queue.poll();
			int x = curList[0];
			int y = curList[1];
			int count = curList[2];
			
			for(int i=0; i<4; i++) {
				int nextX = x + x_move[i];
				int nextY = y + y_move[i];
				if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m && !visited[nextX][nextY] && maze[nextX][nextY] == 1) {
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY, count+1});
					
					if(nextX == n-1 && nextY == m-1) {
						return count+1;
					}
				}
			}
		}
		return ans;
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] maze = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String[] list = st.nextToken().split("");
			int[] numList = Arrays.stream(list).mapToInt(Integer::valueOf).toArray();
			maze[i] = numList;
		}
		
		int answer = bfs(maze,0,0);
		System.out.println(answer);
	}

}