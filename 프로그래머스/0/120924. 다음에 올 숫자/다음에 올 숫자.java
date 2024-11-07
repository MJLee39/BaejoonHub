import java.lang.Math;

class Solution {
    public double solution(int[] common) {
        double answer = 0;
        if(common[1]-common[0] == common[2]-common[1]){
            //등차수열
            answer = common[0]+(common.length)*(common[1]-common[0]);
        }else{
            answer = common[0]*(Math.pow(common[1]/common[0],common.length));
        }
        return answer;
    }
}