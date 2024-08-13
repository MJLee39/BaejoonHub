class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp=1;
        while(temp<=n){
            int sum = 0;
            for(int i=temp;i<=n;i++){
                sum += i;
                if(sum==n){
                    answer++;
                    break;
                }else if(sum>n){
                    break;
                }
            }
            temp++;
        }
        
        return answer;
    }
}