import java.util.*;
import java.io.*;

public class Main {
	
	public static ArrayList<ArrayList<String>> findList(ArrayList<String> aeiou, ArrayList<String> elseList, int i, int j){
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> ansAeiou = new ArrayList<ArrayList<String>>();
		ArrayList<String> currAeiou = new ArrayList<String>();
		boolean[] visitedAeiou = new boolean[aeiou.size()];
		int startAeiou = 0;
		
		ArrayList<ArrayList<String>> ansElse = new ArrayList<ArrayList<String>>();
		ArrayList<String> currElse = new ArrayList<String>();
		boolean[] visitedElse = new boolean[elseList.size()];
		int startElse = 0;
		
		backtracking(aeiou,i,ansAeiou,currAeiou,visitedAeiou,startAeiou);
		backtracking(elseList,j,ansElse,currElse,visitedElse,startElse);
		
		for(int x=0; x<ansAeiou.size(); x++) {
			for(int y=0; y<ansElse.size(); y++) {
				
				ArrayList<String> currList = new ArrayList<String>();
				for(String currA : ansAeiou.get(x)) {
					currList.add(currA);
				}
				for(String currE : ansElse.get(y)) {
					currList.add(currE);
				}
				Collections.sort(currList);
				ans.add(currList);
			}
		}
		
		return ans;
	}
	
	public static void backtracking(ArrayList<String> list, int i, ArrayList<ArrayList<String>> ansList, ArrayList<String> currList, boolean[] visited, int start) {
		if(currList.size() == i) {
			ansList.add(new ArrayList<String>(currList));
			return;
		}
		
		for(int x=start; x<list.size(); x++) {
			if(!visited[x]) {
				visited[x] = true;
				currList.add(list.get(x));
				backtracking(list,i,ansList,currList,visited,x+1);
				
				visited[x] = false;
				currList.remove(currList.size()-1);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<String> aeiou = new ArrayList<String>();
		ArrayList<String> elseList = new ArrayList<String>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			String now = st.nextToken();
			if(now.equals("a") || now.equals("e") || now.equals("i") || now.equals("o") || now.equals("u")) {
				aeiou.add(now);
			}else {
				elseList.add(now);
			}
		}
		Collections.sort(aeiou);
		Collections.sort(elseList);
		
		ArrayList<String> ansList = new ArrayList<String>();
		
		for(int i=1; i<=aeiou.size(); i++) {
			//i는 사용하는 모음 개수, j는 사용하는 자음 개수
			int j = l-i;
			if( j>=2) {
				
				ArrayList<ArrayList<String>> list = findList(aeiou,elseList,i,j);
				for(ArrayList<String> alpaList : list) {
					String ans = "";
					for(String alpa : alpaList) {
						ans += alpa;
					}
					ansList.add(ans);
				} 
			}
		}
		
		Collections.sort(ansList);
		for(String word : ansList) {
			sb.append(word+"\n");
		}
		
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
