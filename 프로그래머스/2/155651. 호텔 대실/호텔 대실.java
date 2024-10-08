import java.util.*;

//시간은 시각에 60 곱해서 다 분으로 관리하기! 
//우선순위 큐
//큐에 비는 시간을 넣기
//큐에 몇개가 있느냐가 의도

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        int[][] newList = new int[book_time.length][2];
        Queue<Integer> queue = new PriorityQueue<Integer>();
        
        //시간을 분으로 변환
        for(int i=0; i<book_time.length; i++){
            for(int j=0; j<2; j++){
                newList[i][j] = Integer.parseInt(book_time[i][j].substring(0,2))*60+Integer.parseInt(book_time[i][j].substring(3,5));
            }
        }
        
        //시작이 빠른 순으로 정렬
        Arrays.sort(newList, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        queue.add(newList[0][1]+10);
        for(int i=1; i < newList.length; i++){
           
            if(queue.peek() <= newList[i][0]){
                queue.poll();
                queue.add(newList[i][1]+10);
            }else{
                answer++;
                queue.add(newList[i][1]+10);
            }
        }
        
        return answer;
    }
}