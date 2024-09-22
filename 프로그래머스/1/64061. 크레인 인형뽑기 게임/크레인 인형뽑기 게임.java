import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[][] newBoard = new int[board.length][board.length];  //번호별로 담긴 배열
        int[] selectArr = new int[moves.length];
        int ind = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                newBoard[j][i] = board[i][j];
            }
        }
        
        for(int m=0;m<moves.length;m++){
            boolean allZ = true;
            for(int a=0;a<newBoard[0].length;a++){
                if(newBoard[moves[m]-1][a]!=0){
                    selectArr[ind] = newBoard[moves[m]-1][a];
                    newBoard[moves[m]-1][a]=0;
                    ind++;
                    allZ = false;
                    break;
                }
            }
        }
        
        List<Integer> ansList = new ArrayList<>();
        int cnt = 0;
        for (int arr : selectArr) {
            if(arr!=0){
                ansList.add(arr);
                cnt++;
            }
        }
        for(int j=0;j<=cnt;j++){
            for(int i=0;i<ansList.size()-1;i++){
                if(ansList.get(i)==ansList.get(i+1)){
                    ansList.remove(i);
                    ansList.remove(i);
                    answer += 2;
                    break;
                }
            }
            if(ansList.size()==0){
                break;
            }
            //System.out.println(ansList);
        }
        
        return answer;
    }
}