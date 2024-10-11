import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] x_move = {1,0,-1,0};
	public static int[] y_move = {0,1,0,-1};
	
	public static int countTime(int n, int[][] map, int[][] turn) {
		int time = 0;
		Queue<int[]> queue = new LinkedList<int[]>(); //꼬리 위치 알기위해
		boolean[][] visited = new boolean[n][n];  //뱀 몸이 있는 위치
		visited[0][0] = true;  //참이면 현재 뱀이 있음
		int[] way = {0,1}; //현재 바라보는 방향
		int[] head = new int[2]; //머리 위치
		int[] tail = new int[2]; //꼬리 위치
		int index = 0; //방향 바꾸기 인덱스
		
		queue.add(new int[]{0,0}); //시작점 넣기 
		
		while(head[0]+way[0] >= 0 && head[0]+way[0] < n && head[1]+way[1] >= 0 && head[1]+way[1] < n && visited[head[0]+way[0]][head[1]+way[1]] != true) {
			queue.add(new int[] {head[0]+way[0],head[1]+way[1]});
			if(map[head[0]+way[0]][head[1]+way[1]] == 1) {
				//사과 있으면 꼬리 안 움직임
				visited[head[0]+way[0]][head[1]+way[1]] = true;
				head[0] = head[0]+way[0];
				head[1] = head[1]+way[1];
				//사과 먹으면 치우기!!
				map[head[0]][head[1]] = 0;
			}else {
				visited[head[0]+way[0]][head[1]+way[1]] = true;
				head[0] = head[0]+way[0];
				head[1] = head[1]+way[1];
				int[] tailList = queue.poll();
				tail[0] = tailList[0];
				tail[1] = tailList[1];
				visited[tail[0]][tail[1]] = false;
			}
			time++;
			//동작 먼저 하고 방향 바꿈 
			if(index < turn.length && turn[index][0] == time) {
				if(turn[index][1] == 1) {
					//오른쪽으로 방향 바꿈
					if(way[0] == 0) {
						//가로방향으로 움직이고 있었을 때
						way[0] = way[1];
						way[1] = 0;
					}else {
						//세로방향으로 움직이고 있었을 때
						way[1] = way[0] * (-1);
						way[0] = 0;
					}
				}else {
					//왼쪽으로 방향 바꿈
					if(way[0] == 0) {
						way[0] = way[1]*(-1);
						way[1] = 0;
					}else {
						way[1] = way[0];
						way[0] = 0;
					}
				}
				index++;	
			}
			
		}
		time++;
		return time;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int[][] turn = new int[l][2];
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D")) {
				turn[i][1] = 1;
			}else {
				turn[i][1] = 0;
			}
		}
		
		answer = countTime(n, map, turn);
		System.out.println(answer);

	}

}
