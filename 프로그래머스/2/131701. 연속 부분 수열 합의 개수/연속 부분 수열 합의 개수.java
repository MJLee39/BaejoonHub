import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<elements.length;i++){
            //길이가 i인 연속 부분수열
            for(int j=0;j<elements.length;j++){
                int num = 0;
                //인덱스가 j인 원소부터 i개 더해 list에 추가
                for(int z=0;z<=i;z++){
                    num += elements[(j+z)%elements.length];
                }
                list.add(num);
            }
        }
        // List를 Set으로 변경
        Set<Integer> set = new HashSet<Integer>(list);
        // Set을 List로 변경
        List<Integer> newList =new ArrayList<Integer>(set);
        // 결과 출력
        //System.out.println(newList);
        answer = newList.size();
        return answer;
    }
}