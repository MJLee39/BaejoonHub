import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int dp(int[] list) {
		int[] d = new int[list.length+1];
		ArrayList<int[]> newDA = new ArrayList<int[]>();  // 0 : D, 1 : A
		
		newDA.add(new int[] {0,0});
		
		for(int i=1; i<list.length; i++) {
			for(int j=0; j<newDA.size(); j++) {
				
				if(newDA.get(newDA.size()-1)[1] < list[i]) {
					//제일 큰 값. D[]추가
					newDA.add(new int[] {newDA.get(newDA.size()-1)[0]+1, list[i]});
					break;
				}else if(newDA.get(j)[1] > list[i] && newDA.get(j-1)[1] < list[i]) {
					//큰 값이 아님. D[]업데이트
					newDA.set(j, new int[] {newDA.get(j)[0], list[i]});
				}else {
					
				}
			}
		}
		
		return newDA.get(newDA.size()-1)[0];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp(list));
	}

}