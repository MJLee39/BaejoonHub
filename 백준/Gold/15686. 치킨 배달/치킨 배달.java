import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static ArrayList<ArrayList<int[]>> combination(ArrayList<int[]> storeList, int m){
		ArrayList<ArrayList<int[]>> ans = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> curr = new ArrayList<int[]>();
		boolean[] used = new boolean[storeList.size()];
		int start = 0;
		
		backtrack(start, storeList, m, ans, curr, used);
		
		return ans;
	}
	
	public static void backtrack(int start, ArrayList<int[]> storeList, int m, ArrayList<ArrayList<int[]>> ans, ArrayList<int[]> curr, boolean[] used) {
		if(curr.size() == m) {
			ans.add(new ArrayList<int[]>(curr));
			return;
		}
		for(int i=start; i < storeList.size(); i++) {
			if(!used[i]) {
				used[i] = true;
				curr.add(storeList.get(i));
				
				backtrack(i+1, storeList, m, ans, curr, used);
				used[i] = false;
				curr.remove(curr.size()-1);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		
		ArrayList<int[]> storeList = new ArrayList<int[]>();
		ArrayList<int[]> home = new ArrayList<int[]>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 2) {
					//치킨집
					storeList.add(new int[] {i,j});
				}else if(num == 1) {
					//집
					home.add(new int[] {i,j});
				}
			}
		}
		
		ArrayList<ArrayList<int[]>> c = combination(storeList, m);
		
		int[] minList = new int[c.size()];  //치킨집 선택한 모든 경우의 별 도시치킨거리 담은 배열
		
		for(int i=0; i<c.size(); i++) {
			//선택한 치킨집의 경우의 수 별 도시치킨거리 모두 계산하기
			//c의 최대 크기는 10의 3승
			for(int h=0; h<home.size(); h++) {
				int home_x = home.get(h)[0];
				int home_y = home.get(h)[1];
				ArrayList<Integer> compare = new ArrayList<Integer>();
				
				for(int j=0; j<m; j++) {
					int x = c.get(i).get(j)[0];  //치킨집 x 좌표
					int y = c.get(i).get(j)[1];  //치킨집 y 좌표
					
					int value = Math.abs(x-home_x)+Math.abs(y-home_y);
					
					compare.add(value);
				}
				Collections.sort(compare);
				
				//minList 값 하나씩 채우기
				minList[i] += compare.get(0);
			}
		}
		
		Arrays.sort(minList);
		System.out.println(minList[0]);
	}

}