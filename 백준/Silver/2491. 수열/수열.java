import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n == 1) {
			System.out.println(1);
		}else {
			Stack<Integer> stack = new Stack<Integer>();
			
			stack.add(arr[0]);
			
			//커지는거 개수 구하기
			int maxBig = 0;
			for(int i=1; i<n; i++) {
				if(!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.add(arr[i]);
				}else if(!stack.isEmpty() && stack.peek() > arr[i]){
					if(maxBig < stack.size()) {
						maxBig = stack.size();
					}
					stack.clear();
					stack.add(arr[i]);
				}else {
					stack.add(arr[i]);
				}
				if(i == n-1) {
					if(maxBig < stack.size()) {
						maxBig = stack.size();
					}
				}
			}
			
			stack.clear();
			stack.add(arr[0]);
			
			//작아지는거 개수 구하기
			int maxSmall = 0;
			
			for(int i=1; i<n; i++) {
				if(!stack.isEmpty() && stack.peek() >= arr[i]) {
					stack.add(arr[i]);
				}else if(!stack.isEmpty() && stack.peek() < arr[i]){
					if(maxSmall < stack.size()) {
						maxSmall = stack.size();
					}
					stack.clear();
					stack.add(arr[i]);
				}else {
					stack.add(arr[i]);
				}
				if(i == n-1) {
					if(maxSmall < stack.size()) {
						maxSmall = stack.size();
					}
				}
			}
			
			
			if(maxBig < maxSmall) {
				System.out.println(maxSmall);
			}else {
				System.out.println(maxBig);
			}
		}
		
	}

}