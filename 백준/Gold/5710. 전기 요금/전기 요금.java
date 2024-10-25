
import java.util.*;
import java.io.*;

public class Main {
	
	//요금에서 사용량 구하기 
	public static int calUse(int a) {
		int useAmount = 0;
		if(a <= 200) {
			useAmount += a/2;
		}else if(a > 200 && a <= 200+9900*3) {
			useAmount = 100 + (a-200)/3;
		}else if(a > 200+9900*3 && a <= 200+9900*3+990000*5) {
			useAmount = 10000 + (a-(200+9900*3))/5;
		}else {
			useAmount = 1000000 + (a-(200+9900*3+990000*5))/7;
		}
		
		return useAmount;
	}
	
	//사용량에서 요금 구하기
	public static int calFee(int use) {
		int fee = 0;
		if(use <= 100) {
			fee = use*2;
		}else if(use > 100 && use <= 10000) {
			fee = 200 + (use-100)*3;
		}else if(use > 10000 && use <= 1000000) {
			fee = 200 + 9900*3 + (use-10000)*5;
		}else {
			fee = 200 + 9900*3 + 990000*5 + (use-1000000)*7;
		}
		
		return fee;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0) {
				break;
			}else {
				int useAmount = calUse(a);
				
				//상근이의 요금 구하기 - 이분 탐색 
				int left = 0;
				int right = useAmount;
				int sangUse = 0;
				int friendUse = 0;
				
				while(left <= right) {
					int mid = (left+right)/2;
					sangUse = mid;
					friendUse = useAmount - sangUse;
					
					int sangFee = calFee(sangUse);
					int friendFee = calFee(friendUse);
					
					if(Math.abs(friendFee - sangFee) == b){
						sb.append(Math.min(friendFee, sangFee)+"\n");
						break;
					}else {
						if(Math.abs(friendFee - sangFee) > b) {
							right = mid - 1;
						}else {
							left = mid + 1;
						}
					}
				}
				
			}
			st = new StringTokenizer(br.readLine());
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
