import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		if(n == 1) {
			System.out.println(1);
		}else {
			int answer = 0;
			for(int i=0; i<n-1; i++) {
				if(3*i*(1+i)+1 < n && 3*(i+1)*(i+2)+1 >= n) {
					answer = i+2;
					break;
				}
			}
			System.out.println(answer);
		}
	}

}