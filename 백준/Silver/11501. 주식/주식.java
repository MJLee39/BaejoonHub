import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long t = Integer.parseInt(st.nextToken());
		for(int i=0; i<t; i++) {
			//테스트 케이스 하나씩
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			long[] list = new long[n];  //주가 list
			long[] saleList = new long[n];
			
			long sum = 0;
			
			for(int j=0; j<n; j++) {
				list[j] = Integer.parseInt(st.nextToken());
			}
			
			saleList[n-1] = list[n-1];
			for(int j=n-2; j>=0; j--) {
				saleList[j] = Math.max(saleList[j+1], list[j]);
			}
			
			for(int j=0; j<n; j++) {
				sum += saleList[j] - list[j];
			}
			
			sb.append(sum+"\n");
		}
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		
	}
}