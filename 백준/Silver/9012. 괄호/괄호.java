import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String[] list = st.nextToken().split("");
			Stack<String> stack = new Stack<String>();
			boolean flag = true;
			for(int j=0; j<list.length; j++) {
				if(list[j].equals("(")) {
					stack.add(")");
				}else {
					if(stack.size() != 0 && stack.peek().equals(list[j])) {
						stack.pop();
					}else {
						flag = false;
						break;
					}
				}
			}
			if(stack.size() == 0 && flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
