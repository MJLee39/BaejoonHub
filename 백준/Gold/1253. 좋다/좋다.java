import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());  //n
		
		int[] arr = new int[n];  //주어진 수열
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  //주어진 수열 기록
		}
		
		if(n <= 2) {
			System.out.println(0);
		}else {
			ArrayList<Integer> goodList = new ArrayList<Integer>();  //좋다 수열
			
			Arrays.sort(arr); //정렬
			
			for(int i=0; i<n; i++) {
				int min = 0;
				int max = n-1;
				while(min < max) {
					if(min == i) {
						if(min+1 < max) {
							min++;
						}else {
							break;
						}
					}
					if(max == i) {
						if(min < max-1) {
							max--;
						}else {
							break;
						}
					}
					if(arr[min] + arr[max] > arr[i]) {
						max--;
					}else if(arr[min] + arr[max] < arr[i]) {
						min++;
					}else {
						goodList.add(arr[i]);
						break;
					}
				}
				
			}
			
			System.out.println(goodList.size());
		}	
	}
}