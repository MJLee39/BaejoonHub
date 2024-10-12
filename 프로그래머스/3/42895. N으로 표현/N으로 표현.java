import java.util.*;

class Solution {
    
    //두 set집합 합치기
    public void union(Set<Integer> all, Set<Integer> a, Set<Integer> b){
        for(int x : a){
            for(int y : b){
                all.add(x+y);
                all.add(x-y);
                all.add(x*y);
                if(y != 0){
                    all.add(x/y);
                }
            }
        }
    }
    
    public int solution(int N, int number) {
        int answer = -1;
        if(number == N){
            return 1;
        }
        
        ArrayList<Set<Integer>> setList = new ArrayList<Set<Integer>>();
        for(int i=0; i<9; i++){
           setList.add(new HashSet<Integer>());
        }
        
        setList.get(1).add(N);
        for(int i=2; i<=8; i++){
            for(int j = 1; j <= i-1; j++){
                union(setList.get(i), setList.get(i-j), setList.get(j));
            }
            
            String str = N+"";
            setList.get(i).add(Integer.parseInt(str.repeat(i)));
            
            if(setList.get(i).contains(number)){
                return i;
            }
        }
        
        return answer;
    }
}