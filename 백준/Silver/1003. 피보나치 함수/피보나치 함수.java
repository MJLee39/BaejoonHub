import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] fibonacci(int n) {
		int[][] ans = new int[n+1][2];
		
		if(n >= 0) {
			ans[0][0] = 1;
		}
		
		if(n >= 1) {
			ans[1][1] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			ans[i][0] = ans[i-1][0] + ans[i-2][0];
			ans[i][1] = ans[i-1][1] + ans[i-2][1];
		}
		
		return ans[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int[] list = new int[n]; 
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
			int[] ansList = fibonacci(list[i]);
			
			sb.append(ansList[0]+" "+ansList[1]+"\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
