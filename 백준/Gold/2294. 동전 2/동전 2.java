import java.util.*;
import java.io.*;

public class Main {
	
	public static int findMin(int n, int k, ArrayList<Integer> arr) {
		int[] list = new int[k+1];
		
		for(int i=0; i<arr.size(); i++) {
			if(k >= arr.get(i)) {
				list[arr.get(i)] = 1;
			}
		}
		
		for(int i=arr.get(0)+1; i<=k; i++) {
			int min = 1000000000;
			for(int j=0; j<arr.size(); j++) {
				if(i-arr.get(j) > 0 && i-arr.get(j) >= arr.get(0)) {
					min = Math.min(list[i-arr.get(j)]+1, min);
				}else if(i-arr.get(j) == 0) {
					min = 1;
				}
			}
			list[i] = min;
		}
		
		if(list[k] == 0 || list[k] == 1000000000) {
			return -1;
		}
		return list[k];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			if(!arr.contains(now)) {
				arr.add(now);
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(findMin(n,k,arr));
	}

}
