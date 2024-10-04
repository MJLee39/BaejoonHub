import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int total = stages.length;
        int allclear = 0;  //다 깬 사람 수
        int lastStage = -1;  //마지막 판 못 깬 사람 시작하는 인덱스
    
        HashMap<Integer,Double> map = new HashMap<>();  //<스테이지,실패율>
        Arrays.sort(stages);  //일단 스테이지 순서로 정렬
        for(int i=0; i<stages.length; i++){
            //System.out.print("숫자: "+stages[i]);
            int num = 1;
            if(stages[i]==N){
                lastStage = i; //마지막 판 못 깬 사람 시작하는 인덱스
            }else if(stages[i]==N+1){
                allclear = stages.length-i; //모두 다 깬 사람 수
            }
            
            for(int j=i+1; j<stages.length; j++){
                if(stages[i]==stages[j]){
                    //중복인 스테이지 몇개인지 찾기
                    num++;
                }
            }
            //System.out.print(",allclear: "+allclear);
            
            if(allclear>0 && lastStage!=-1){
                //마지막 스테이지 못 깬 사람 있고, 모두 다 깬 사람도 있을때
                map.put(N,(double)(total-lastStage-allclear)/(total-lastStage));
            }else if(allclear>0 && lastStage==-1){
                //마지막 스테이지 못 깬 사람 없고, 모두 다 깬 사람이 있을때
                map.put(N,(double)0);
            }else{
                //이외의 스테이지 실패율
                map.put(stages[i],(double)num/(total-i));
            }
            //중복된 스테이지 건너뛰기
            i = i+num-1;
        }
        
        //스테이지에 도달한 유저가 없을 경우 실패율은 0
        for(int i=1; i<=N;i++){
            if(!map.containsKey(i)){
                map.put(i,(double)0);
            }
        }
        
        //map의 value값 기준으로 내림차순 정렬
        List<Integer> entryList = new ArrayList<>(map.keySet());
        Collections.sort(entryList, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
       
        //map의 key값을 list에 담기
        List<Integer> ans = new ArrayList<>();
        for(int key : entryList) {
			//System.out.println("key : " + key + " , " + "value : " + map.get(key));
            ans.add(key);
		}
        
        //Integer list를 int[]배열로 바꾸기
        answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}