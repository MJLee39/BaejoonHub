import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int max = Math.max(Math.max(a, b),c);
			int sum = a + b + c;
			
			if(a == 0 && b == 0 && c == 0) {
				break;
			}else {
				if(max >= sum-max) {
					System.out.println("Invalid");
				}else if(a == b && b == c) {
					System.out.println("Equilateral");
				}else if(a != b && b != c && c != a) {
					System.out.println("Scalene");
				}else {
					System.out.println("Isosceles");
				}
			}
			
		}
	}

}
