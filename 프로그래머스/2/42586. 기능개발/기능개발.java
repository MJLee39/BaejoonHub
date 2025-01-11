import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int all = 0;
        int index = 0;
        for(int day=1;day<=100;day++){
            //System.out.println(day+"날 경과");
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<progresses.length;i++){
                list.add(progresses[i]+speeds[i]*day);
            }
            int count = 0;
            for(int j=index;j<list.size();j++){
                if(list.get(j)>=100){
                    //System.out.println("어떤 인덱스가 100이 넘어: "+j);
                    count++;
                    list.set(j,-100);
                    for(int z=j+1;z<list.size();z++){
                        if(list.get(z)>=100){
                            count++;
                            list.set(z,-100);
                        }else{
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            index += count;
            //System.out.println(count);
            //System.out.println(list);  
            if(count!=0){
                ans.add(count);
                all += count;
                count = 0;
            }
            //System.out.println("all: "+all);
            if(all==progresses.length){
                break;
            }
        }
        //System.out.println("정답: "+ans);
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}