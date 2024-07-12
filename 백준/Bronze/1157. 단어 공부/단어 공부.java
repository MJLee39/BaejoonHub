import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String word = st.nextToken().toUpperCase();
		
		String[] list = word.split("");
		int max = 0;
		String answer = "";
		
		for(int i=0; i<list.length; i++) {
			if(map.containsKey(list[i])) {
				map.put(list[i], map.get(list[i])+1);
				if(max < map.get(list[i])) {
					max = map.get(list[i]);
				}
			}else {
				map.put(list[i], 1);
				if(max < map.get(list[i])) {
					max = map.get(list[i]);
				}
			}
		}
		
		for(String str : map.keySet()) {
			if(map.get(str) == max) {
				answer += str;
			}
		}
		
		if(answer.length() > 1) {
			System.out.println("?");
		}else {
			System.out.println(answer);
		}
	}

}
