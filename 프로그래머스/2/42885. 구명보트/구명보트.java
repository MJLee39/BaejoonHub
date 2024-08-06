import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();
        for (int person : people) {
            list.add(person);
        }
        //System.out.println(list);
        while(list.size()>1){
            if(list.get(0)+list.get(list.size()-1)>limit){
            //혼자 타야 하는 경우
            list.remove(list.size()-1);
            answer++;
            }else{
                //두명 같이 타도 되는 경우
                list.remove(list.get(0));
                list.remove(list.size()-1);
                answer++;
            }
        }
        if(list.size()==1){
            answer++;
        }
        //System.out.println(list);
        return answer;
    }
}