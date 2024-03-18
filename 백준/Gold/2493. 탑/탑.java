import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] ans = new int[n];
		
		int[] list = new int[n+1];
		ArrayList<int[]> arr = new ArrayList<int[]>(); //튜플
		//arr.add(new int[] {0,0});
		
		for(int i=1; i<=n; i++) {
			int[] tuple = new int[2];
			list[i] = Integer.parseInt(st.nextToken());
			tuple[0] = list[i];
			tuple[1] = i;
			arr.add(tuple);
		}
		
		Stack<int[]> stack = new Stack<int[]>();
		
		stack.add(arr.get(n-1));
		for(int i=n-2; i>=0; i--) {
			
			while(!stack.isEmpty() && stack.peek()[0] < arr.get(i)[0]) {
				//System.out.println("stack.peek: "+Arrays.toString(stack.peek()));
				//System.out.println(i+"번째 arr 값:"+arr.get(i)[0]);
				
				ans[stack.peek()[1]-1] = arr.get(i)[1];
				stack.pop();
			}
			stack.add(arr.get(i));
		}
		
		//System.out.println(Arrays.toString(ans));
		for(int i=0; i<ans.length; i++) {
			sb.append(ans[i]+" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}