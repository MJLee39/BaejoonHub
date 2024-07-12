import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		int answer = 0;
		if(st.length() != 1 &&st.substring(0,1).equals(" ")) {
			answer--;
		}
		String[] list = st.split(" ");
		answer += list.length;
		System.out.println(answer);
	}

}