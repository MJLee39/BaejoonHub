import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if(n == 0) {
			System.out.println(1);
		}else {
			int[] scoreList = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				scoreList[i] = Integer.parseInt(st.nextToken());
			}
			
			if(n < p) {
				boolean flag = true;
				for(int i=0; i<n; i++) {
					if(scoreList[i] <= newScore) {
						flag = false;
						System.out.println(i+1);
						break;
					}
				}
				if(flag) {
					System.out.print(n+1);
				}
			}else {
				// n == p이면 무조건 제일 작은 점수보다 커야 함
				if(scoreList[n-1] >= newScore) {
					System.out.println(-1);
				}else {
					for(int i=0; i<n; i++) {
						if(scoreList[i] <= newScore) {
							System.out.println(i+1);
							break;
						}
					}
				}
			}
		}
		
	}
}