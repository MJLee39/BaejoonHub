import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] x_move = {0,1,0,-1};
	public static int[] y_move = {1,0,-1,0};
	
	//벽 3개 조합으로 선택 	
	public static ArrayList<ArrayList<int[]>> whereIsWall(ArrayList<int[]> arr){
		ArrayList<ArrayList<int[]>> ans = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> curr = new ArrayList<int[]>();
		boolean[] visited = new boolean[arr.size()];
		int start = 0;
		
		backtracking(arr, ans, curr, visited, start);
		
		return ans;
	}
	
	public static void backtracking(ArrayList<int[]> arr, ArrayList<ArrayList<int[]>> ans, ArrayList<int[]> curr, boolean[] visited, int start) {
		if(curr.size() == 3) {
			ans.add(new ArrayList<int[]>(curr));
			return;
		}
		
		for(int i=start; i<arr.size(); i++) {
			if(!visited[i]) {
				curr.add(arr.get(i));
				visited[i] = true;
				backtracking(arr, ans, curr, visited, i+1);
				
				visited[i] = false;
				curr.remove(curr.size()-1);
			}
		}
	}
	
	//바이러스 퍼지는 함수
	public static int[][] virous(int[][] newMap){
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[newMap.length][newMap[0].length];
		
		for(int i=0; i<newMap.length; i++) {
			for(int j=0; j<newMap[0].length; j++) {
				if(newMap[i][j] == 2) {
					queue.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i=0; i<4; i++) {
				int next_x = now[0] + x_move[i];
				int next_y = now[1] + y_move[i];
				
				if(next_x < 0 || next_x >= newMap.length || next_y < 0 || next_y >= newMap[0].length || visited[next_x][next_y] || newMap[next_x][next_y] == 1 || newMap[next_x][next_y] == 2) {
					continue;
				}
				
				newMap[next_x][next_y] = 2;
				queue.add(new int[] {next_x,next_y});
				visited[next_x][next_y] = true;
			}
		}
		
		return newMap;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int max = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					arr.add(new int[]{i,j});
				}
			}
		}
		
		ArrayList<ArrayList<int[]>> walls = whereIsWall(arr);
		
		for(ArrayList<int[]> wall : walls) {
			int count = 0;
			int[] fristWall = wall.get(0);
			int[] secondWall = wall.get(1);
			int[] threadWall = wall.get(2);
			
			int[][] newMap = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			
			newMap[fristWall[0]][fristWall[1]] = 1;
			newMap[secondWall[0]][secondWall[1]] = 1;
			newMap[threadWall[0]][threadWall[1]] = 1;
			
			
			int[][] after = virous(newMap);
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(after[i][j] == 0) {
						count++;
					}
				}
			}
			max = Math.max(count, max);
		}
		System.out.println(max);
	}

}
