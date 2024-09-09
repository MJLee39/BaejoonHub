import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int x = w / (m+1);
		int y = h / (n+1);
		
		if(w % (m+1) != 0) {
			x++;
		}
		
		if(h % (n+1) != 0) {
			y++;
		}
		
		System.out.println(x*y);
	}

}
