import java.util.*;
import java.io.*;

public class Main {
	
	public static int dp(int n, int[] memo, int[] stair) {
		
		memo[1] = stair[1];
		
		if(n >= 2) {
			memo[2] = Math.max(memo[1]+stair[2], stair[2]);
		}
		
		if(n >= 3 && memo[n] == 0) {
			memo[n] = Math.max(dp(n-2,memo,stair)+stair[n], dp(n-3,memo,stair)+stair[n-1]+stair[n]);
		}
		
		return memo[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] memo = new int[n+1];
		int[] stair = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			stair[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp(n, memo, stair));
	}
	

}
