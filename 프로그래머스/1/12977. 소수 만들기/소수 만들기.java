import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int z=j+1;z<nums.length;z++){
                    //System.out.print(nums[i]+nums[j]+nums[z]);
                    list.add(nums[i]+nums[j]+nums[z]);
                    for(int t=2;t<nums[i]+nums[j]+nums[z];t++){
                        if((nums[i]+nums[j]+nums[z])%t==0){
                            list.remove(Integer.valueOf(nums[i]+nums[j]+nums[z]));
                            break;
                        }
                        //list.add(nums[i]+nums[j]+nums[z]);
                    }
                }
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(list);
        answer = list.size();
        return answer;
    }
}