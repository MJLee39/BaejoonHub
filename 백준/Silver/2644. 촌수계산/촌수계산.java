import java.util.*;
import java.io.*;

public class Main {
	
	public static int dfs(HashMap<Integer,ArrayList<Integer>> map, boolean[] visited, int curr, int tar, int count) {
		visited[curr] = true;
		
		if(curr == tar) {
			return count;
		}else {
			if(map.containsKey(curr)) {
				for(int next : map.get(curr)) {
					if(!visited[next]) {
						int num = dfs(map, visited, next, tar, count+1);
						if(num != -1) {
							return num;
						}
					}
				}
			}
			
			for(int i : map.keySet()) {
				if(map.get(i).contains(curr)) {
					if(!visited[i]) {
						int num = dfs(map, visited, i, tar, count+1);
						if(num != -1) {
							return num;
						}
					}
				}
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] target = new int[2];
		target[0] = Integer.parseInt(st.nextToken());
		target[1] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			if(map.containsKey(parent)){
				ArrayList<Integer> list = map.get(parent);
				list.add(child);
				map.put(parent, list);
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(child);
				map.put(parent, list);
			}
		}
		
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		
		int ans = dfs(map, visited, target[0], target[1], 0);
		
		if(!visited[target[1]]) {
			//방문 못함
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}

}
