import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		int[] sumList = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		sumList[1] = list[0];
		for(int i=2; i<n+1; i++) {
			sumList[i] = list[i-1] + sumList[i-1];
		}
		
		int min = n+1;
		
		for(int i=0; i<n+1; i++) {
			int l = i+1;
			while(l < n+1) {
				if(sumList[l] - sumList[i] >= s) {
					if(min > l-i) {
						min = l-i;
					}
					break;
				}else {
					l += 1;
				}
			}
		}
		
		if(min == n+1) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
		
	}

}
