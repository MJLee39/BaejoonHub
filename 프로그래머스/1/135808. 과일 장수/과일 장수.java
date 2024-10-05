import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int boxs = score.length/m;  //팔 수 있는 사과박스 수
        int[][] box = new int[boxs][m];   //박스 구성
        int z = 0;  //score 인덱스
        
        //int[] 내림차순 정렬
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); 
        score = Arrays.stream(tmp).mapToInt(Integer::intValue).toArray(); 
        
        for(int i=0;i<boxs;i++){
            for(int j=0;j<m;j++){
                box[i][j] = score[z];
                z++;
            }
            //System.out.println(Arrays.toString(box[i]));
            //System.out.println("사과 점수:"+box[i][m-1]*m);
            answer += box[i][m-1]*m;
        }
        
        
        return answer;
    }
}