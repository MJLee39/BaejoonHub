import java.util.*;
import java.io.*;

public class Main {
	
	public static int countScore(int[][] list, int score) {
		int[][] dp = new int[list[0].length][3];
		int n = list[0].length;
		dp[0][0] = list[0][0];
		dp[0][1] = list[1][0];
		dp[0][2] = 0;
		if(n>=2) {
			for(int i=1; i<n; i++) {
				dp[i][0] = Math.max(dp[i-1][1]+list[0][i], dp[i-1][2]+list[0][i]);
				dp[i][1] = Math.max(dp[i-1][0]+list[1][i], dp[i-1][2]+list[1][i]);
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]);
			}
		}
		
		return Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] list = new int[2][n];
			for(int j=0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				int[] listFrist = new int[n];
				for(int k=0; k<n; k++) {
					listFrist[k] = Integer.parseInt(st.nextToken());
				}
				list[j] = listFrist;
			}
			System.out.println(countScore(list, 0));
		}
		
	}

}