import java.util.*;
import java.io.*;

public class Main {
	
	public static long countMax(int[][] jList, int[] bList) {
		long ans = 0;
		Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int jindex = 0;
		
		for(int bag : bList) {
			while(jindex < jList.length && jList[jindex][0] <= bag) {
				queue.add(jList[jindex][1]);
				jindex++;
			}
			
			if(!queue.isEmpty()) {
				ans += queue.poll();
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] jList = new int[n][2];
		int[] bList = new int[k];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			jList[i][0] = Integer.parseInt(st.nextToken());
			jList[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(jList, (o1, o2) -> {
			if(o2[0] == o1[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			bList[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(bList);
		
		System.out.println(countMax(jList, bList));
	}

}
