import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        //System.out.println("처음: "+map);
        for(int i=0;i<discount.length-9;i++){
            for(int t=0;t<want.length;t++){
                map.put(want[t],number[t]);
            }
            boolean all = true;
            for(int j=i;j<i+10;j++){
                if(map.get(discount[j])!= null && map.get(discount[j])>0){
                    map.put(discount[j], map.get(discount[j]) - 1);
                }
            }
            for(String item:want){
                if(map.get(item)!=0){
                    //System.out.println("중지"+i);
                    all = false;
                    break;
                }
            }
            if(all){
                //System.out.println("성공"+i);
                answer++;
            }
            //System.out.println("결과 : " + map);
        }
        //System.out.println(map);
        return answer;
    }
}