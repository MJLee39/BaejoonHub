import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int temp = 0;
        int num = nums.length/2; //고를 수 있는 포켓몬 수
        int[] pick = new int[num];  //선택한 포켓몬
        int sp = 0;  //포켓몬 종류
        //System.out.print(num);
        for(int i=0; i<nums.length;i++){
            for(int j=temp; j<num; j++){
                if(!Arrays.stream(pick)
                            .boxed()
                            .collect(Collectors.toSet())
                            .contains(nums[i])){
                    pick[j] = nums[i];       
                    sp += 1;
                    temp += 1;
                    //System.out.println("pick:"+Arrays.toString(pick));
                    //System.out.println("sp: "+sp);
                    break;
                }else{
                    break;
                }
            }
        }
        answer = sp;
        return answer;
    }
}