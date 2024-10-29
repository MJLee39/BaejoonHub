import java.util.*;
import java.io.*;

public class Main {
	
	public static int findMin(int n) {
		int[] list = new int[n+1];
		
		if(n>=2) {
			list[2] = 1;
		}
		if(n>=3) {
			list[3] = 1;
		}
		
		for(int i=4; i<=n; i++) {
			int min = 1000000000;
			if(i % 3 == 0) {
				min = Math.min(list[i/3] + 1, min);
			}
			if(i % 2 == 0) {
				min = Math.min(list[i/2] + 1, min);
			}
			
			list[i] = Math.min(list[i-1]+1, min);
		}
		
		
		return list[n];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		System.out.println(findMin(n));
	}

}
