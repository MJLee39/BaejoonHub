import java.util.*;
import java.io.*;

public class Main {
	
	public static int dfs(int n, HashMap<Integer, ArrayList<Integer>> map, int curr, HashMap<Integer, Boolean> visited) {
		visited.put(curr, true);
		if(map.containsKey(curr)) {
			for(int next : map.get(curr)) {
				if(!visited.containsKey(next)) {
					dfs(n, map, next, visited);
				}
			}
		}
		
		return visited.size()-1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();  //감염된 컴퓨터 리스트
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int link = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)){
				ArrayList<Integer> newList = map.get(num);
				newList.add(link);
				map.put(num, newList);
			}else {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(link);
				map.put(num, newList);
			}
			if(map.containsKey(link)){
				ArrayList<Integer> newList = map.get(link);
				newList.add(num);
				map.put(link, newList);
			}else {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				newList.add(num);
				map.put(link, newList);
			}
		}
		
		System.out.println(dfs(n,map,1, visited));
	}

}
