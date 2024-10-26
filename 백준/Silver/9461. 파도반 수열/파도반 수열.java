import java.util.*;
import java.io.*;

public class Main {
	
	public static long[] find(int[] list, int max) {
		long[] ansList = new long[list.length];
		
		ArrayList<Long> numList = new ArrayList<Long>();
		numList.add(0L);
		numList.add(1L);
		numList.add(1L);
		numList.add(1L);
		numList.add(2L);
		
		for(int i=5; i<=max; i++) {
			numList.add(numList.get(i-1) + numList.get(i-5));
		}
		
		for(int i=0; i<list.length; i++) {
			ansList[i] = numList.get(list[i]);
		}
		
		return ansList;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = Integer.parseInt(st.nextToken());
			if(max < list[i]) {
				max = list[i];
			}
		}
		
		long[] ans = find(list, max);
		
		for(int i=0; i<n; i++) {
			sb.append(ans[i]+"\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
