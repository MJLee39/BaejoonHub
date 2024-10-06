import java.util.*;
import java.io.*;

public class Main {
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int oneCoin : coin) {
			for(int i = oneCoin; i <= k; i++) {
				dp[i] += dp[i - oneCoin];
			}
		}
		
		System.out.println(dp[k]);
		
	
	}
}
