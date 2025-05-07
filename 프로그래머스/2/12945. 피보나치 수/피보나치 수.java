import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0,0);
        list.add(1,1);
        for(int i=2; i<=n; i++){
            list.add(i,(list.get(i-1)+list.get(i-2))%1234567);
        }
        //System.out.print(list.get(n));
        answer = list.get(n);
        return answer;
    }
}