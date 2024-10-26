import java.util.*;
import java.io.*;

public class Main {
	
	public static int countNum(String document, String target) {
		int ans = 0;
		String[] docList = document.split("");
		String[] tarList = target.split("");
		boolean[] visited = new boolean[docList.length];
		
		for(int i=0; i<docList.length; i++) {
			//타겟의 첫글자 발견! 뒤에도 같은지 확인
			if(docList[i].equals(tarList[0])) {
				boolean flag = true;
				for(int j=1; j<tarList.length; j++) {
					if(i+j >= docList.length || visited[i] || !docList[i+j].equals(tarList[j])) {
						//틀림
						flag = false;
						break;
					}
				}
				if(flag) {
					ans++;
					for(int k=i; k<i+tarList.length; k++) {
						visited[k] = true;
					}
				}
			}
		}
		
		
		if(document.contains(target)) {
			
		}
		
		return ans;
	}
	
	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		String document = sc.nextLine();
		String target = sc.nextLine();
		
		System.out.println(countNum(document, target));
		
	}

}
