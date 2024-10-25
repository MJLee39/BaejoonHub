
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] time = new int[n][2];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String[] hour = st.nextToken().split(":");
			time[i][0] = Integer.parseInt(hour[0])*60+Integer.parseInt(hour[1]);
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			if(time[i][0]>=420 && time[i][0]<=1140) {
				//시작시간이 7~19
				if(time[i][0]+time[i][1] >= 420 && time[i][0]+time[i][1] <= 1140) {
					//끝나는 시간도 7~19
					answer += time[i][1] * 10;
				}else {
					//끝나는 시간은 19 넘어감
					answer += (time[i][0]+time[i][1] - 1140) * 5 + (1140 - time[i][0]) * 10;
				}
			}else {
				//시작시간이 7~19 넘어감
				if(time[i][0]+time[i][1] <= 420 || time[i][0]+time[i][1] > 1140) {
					//끝나는 시간이 자정  19~7 사이 
					answer += time[i][1] * 5;
				}else{
					//끝나는 시간이 7~19 사이
					answer += (420 - time[i][0]) * 5 + (time[i][0]+time[i][1]-420) * 10;
				}
			}
		}
		
		System.out.println(answer);
	}

}
