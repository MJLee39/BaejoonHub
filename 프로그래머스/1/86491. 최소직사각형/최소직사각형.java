import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int max_2 = 0;
        for(int[] item : sizes){
            int instead = 0;
            //System.out.print(Arrays.toString(item));
            if(item[0]>item[1]){
                instead = item[1];
                item[1] = item[0];
                item[0] = instead;
            }
            //System.out.println(":"+Arrays.toString(item));
            if(max < item[1]){
                max = item[1];
            }
            if(max_2 < item[0]){
                max_2 = item[0];
            }
        }
        //System.out.println("max:"+max);
        //System.out.println("max_2:"+max_2);
        answer = max*max_2;
        return answer;
    }
}