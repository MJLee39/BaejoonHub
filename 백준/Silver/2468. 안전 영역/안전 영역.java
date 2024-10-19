import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] x_move = {1,0,-1,0};
	public static int[] y_move = {0,1,0,-1};
	
	public static void dfs(int[][] map, int rainLevel, boolean[][] visited, int cur_x, int cur_y) {
		visited[cur_x][cur_y] = true;
		for(int i=0; i<4; i++) {
			int next_x = cur_x + x_move[i];
			int next_y = cur_y + y_move[i];
			if(next_x >= 0 && next_x < map.length && next_y >= 0 && next_y < map.length) {
				if(!visited[next_x][next_y] && map[next_x][next_y] > rainLevel) {
					dfs(map, rainLevel, visited, next_x, next_y);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		
		int rain = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(rain < map[i][j]) {
					rain = map[i][j];  //제일 높은 곳
				}
			}
		}
		
		int[] list = new int[rain]; //각 수위 별 안전지대 개수 담은 리스트
		
		for(int i=0; i<rain; i++) {
			boolean[][] visited = new boolean[n][n];
			int count = 0;
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					if(map[x][y] > i && !visited[x][y]) {
						count++;
						dfs(map, i, visited, x, y);
					}
				}
			}
			list[i] = count;
		}
		
		Arrays.sort(list);
		
		System.out.println(list[rain-1]);
	}

}
