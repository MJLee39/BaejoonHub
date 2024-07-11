import java.util.*;
import java.io.*;

public class Main {
	
	public static ArrayList<ArrayList<Integer>> printSeq(int n, int m, boolean[] visited){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		
		backtracking(n,m,visited,ans,curr);
		
		return ans;
	}
	
	public static void backtracking(int n, int m, boolean[] visited, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
		if(curr.size() == m) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				curr.add(i);
				backtracking(n, m, visited, ans, curr);
				visited[i] = false;
				curr.remove(curr.size()-1);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[n+1];
		
		for(ArrayList<Integer> seq : printSeq(n, m, visited)) {
			for(int i=0; i<seq.size(); i++) {
				sb.append(seq.get(i)+" ");
			}
			sb.append('\n');
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
