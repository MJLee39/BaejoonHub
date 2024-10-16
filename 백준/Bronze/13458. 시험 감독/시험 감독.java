import java.util.*;
import java.io.*;

public class Main {
	
	public static long dp(int n, int[] student, int b, int c) {
		long answer = 0;
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(student[i])) {
				if(student[i] < b) {
					map.put(student[i], 1L);
					answer += 1;
				}else {
					long count = 1 + (long)Math.ceil(((double)student[i]-b)/c);
					map.put(student[i], count);
					answer += count;
				}
			}else {
				answer += map.get(student[i]);
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] student = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(dp(n, student, b, c));
	}

}
