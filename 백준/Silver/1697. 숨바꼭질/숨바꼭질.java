import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] move = {-1, 1, 2};
	
	public static int bfs(int n, int k, int time) {
		boolean[] visited = new boolean[1000001];
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[n] = true;
		queue.add(new int[] {n, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int curX = curr[0];
			int curTime = curr[1];
			
			for(int i=0; i<3; i++) {
				int nextX = 0;
				if(i == 2) {
					nextX = curX * 2;
				}else {
					nextX = curX + move[i];
				}
				if(nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
					if(nextX == k) {
						visited[nextX] = true;
						return curTime+1;
					}else {
						visited[nextX] = true;
						queue.add(new int[] {nextX, curTime+1});
						
					}
				}
			}
		}
		
		return time;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		if(n == k) {
			System.out.println(0);
		}else {
			System.out.println(bfs(n,k,0));
		}
	}

}
