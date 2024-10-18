import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] x_move = {1,0,-1,0,0,0};
	public static int[] y_move = {0,1,0,-1,0,0};
	public static int[] z_move = {0,0,0,0,1,-1};
	
	public static int bfs(int[][][] box, int m, int n, int h, ArrayList<int[]> already) {
		int answer = 0;
		boolean[][][] visited = new boolean[h][n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<already.size(); i++) {
			int[] curr = already.get(i);
			int low = curr[0];
			int col = curr[1];
			int high = curr[2];
			visited[high][low][col] = true;
			queue.add(curr);
		}
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int curr_low = curr[0];
			int curr_col = curr[1];
			int curr_high = curr[2];
			int curr_date = curr[3];
			for(int i=0; i<6; i++) {
				int next_low = curr_low + x_move[i];
				int next_col = curr_col + y_move[i];
				int next_high = curr_high + z_move[i];
				int next_date = curr_date + 1;
				//내부에 있기
				if(0<= next_low && next_low < n && 0 <= next_col && next_col < m && 0 <= next_high && next_high < h) {
					//방문 안 했고 0일 때
					if(!visited[next_high][next_low][next_col] && box[next_high][next_low][next_col] == 0) {
						visited[next_high][next_low][next_col] = true;
						queue.add(new int[] {next_low, next_col, next_high, next_date});
						if(answer < next_date) {
							answer = next_date;
						}
					}
				}
			}
		}
		
		boolean finalFlag = false;
		loop : 
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(box[i][j][k] == 0 && !visited[i][j][k]) {
						//방문 안 한 곳 남음
						finalFlag = true;
						break loop;
					}
				}
			}
		}
		
		if(finalFlag) {
			answer = -1;
		}
		
		
		return answer;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[h][n][m];
		ArrayList<int[]> already = new ArrayList<int[]>();  //익은거 위치
		boolean flag = true;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 0) {
						flag = false;
					}else if(box[i][j][k] == 1) {
						already.add(new int[] {j,k,i,0});
					}
				}
			}
		}
		
		if(flag) {
			System.out.println(0);
		}else {
			System.out.println(bfs(box,m,n,h,already));
		}
	}

}
