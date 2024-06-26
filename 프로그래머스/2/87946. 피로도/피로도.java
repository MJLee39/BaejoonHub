import java.util.*;

class Solution {
    
    public ArrayList<ArrayList<int[]>> per(int[][] dungeons){
        ArrayList<ArrayList<int[]>> answer = new ArrayList<ArrayList<int[]>>();
        ArrayList<int[]> curr = new ArrayList<int[]>();
        boolean[] used = new boolean[dungeons.length];
        
        backtrack(dungeons, answer, curr, used);
        
        return answer;
    }
    
    public void backtrack(int[][] dungeons, ArrayList<ArrayList<int[]>> answer, ArrayList<int[]> curr, boolean[] used){
        if(curr.size() == dungeons.length){
            answer.add(new ArrayList<int[]>(curr));
        }
    
        for(int i=0; i<dungeons.length; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(dungeons[i]);
                backtrack(dungeons, answer, curr, used);
                used[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int max = 0;
        ArrayList<ArrayList<int[]>> p = new ArrayList<ArrayList<int[]>>();
        p = per(dungeons);
        for(ArrayList<int[]> arr : p){
            int new_k = k;
            int num = 0;
            for(int[] cur_arr : arr){
                if(new_k >= cur_arr[0]){
                    new_k = new_k-cur_arr[1];
                    num++;
                }else{
                    break;
                }
            }
            if(num > max){
                max = num;
            }
        }
        answer = max;
        return answer;
    }
}