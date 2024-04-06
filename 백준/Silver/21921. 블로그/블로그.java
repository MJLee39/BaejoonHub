import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int count = 0;
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n];
		
		int[] newList = new int[n-x+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		//newList[0] 구하기
		for(int i=0; i<x; i++) {
			sum += list[i];
		}
		
		newList[0] = sum;
		max = sum;
		
		//newList[i]는 list[i]를 포함하는 x일의 방문자수 합
		for(int i=1; i<newList.length; i++) {
			newList[i] = newList[i-1] - list[i-1] + list[i+x-1];
			if(max < newList[i]) {
				max = newList[i];
			}
		}
		
		for(int i=0; i<newList.length; i++) {
			if(newList[i] == max) {
				count++;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(count);
		}
	}

}