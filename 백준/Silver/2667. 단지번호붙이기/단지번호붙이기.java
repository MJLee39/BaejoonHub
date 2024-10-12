import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] x_move = {1,0,-1,0};
	public static int[] y_move = {0,1,0,-1};
	
	//dfs로 단지 탐색하는 함수
	public static int dfs(int cur_x, int cur_y, int n, String[][] map, boolean[][] visited){
		visited[cur_x][cur_y] = true;  //현재 방문 처리
		int count = 1; //현재 집도 단지로 속하므로 1로 초기화
		
		for(int i=0; i<4; i++) {
			int next_x = cur_x + x_move[i];
			int next_y = cur_y + y_move[i];
			if(next_x >= 0 && next_x < n && next_y >= 0 && next_y < n && !visited[next_x][next_y] && map[next_x][next_y].equals("1")) {
				//재귀로 연결된 집 모두 방문
				count += dfs(next_x, next_y, n, map, visited);
			}
		}
		
		return count;
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		String[][] map = new String[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String[] list = st.nextToken().split("");
			map[i] = list;
		}
		boolean[][] visited = new boolean[n][n];
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].equals("1") && !visited[i][j]) {
					int complexSize = dfs(i,j,n,map,visited);
					answer.add(complexSize);
				}
			}
		}
		
		Collections.sort(answer);
		
		sb.append(answer.size()+"\n");
		for(int i=0; i<answer.size(); i++) {
			sb.append(answer.get(i)+"\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
