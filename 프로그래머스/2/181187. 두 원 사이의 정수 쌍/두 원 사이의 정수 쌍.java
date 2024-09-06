class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i=1;i<r2;i++){
            double r2Num = Math.floor(Math.sqrt(Math.pow(r2,2)-Math.pow(i,2)));
            double r1Num = Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(i,2)));
            if(i>=r1){
                r1Num = 0;
                answer += r2Num - r1Num;
            }else{
                answer += r2Num - r1Num + 1;
            }
            
        }
        
        answer = answer*4;
        answer += (r2-r1+1)*4;
        return answer;
    }
}
//2+4+