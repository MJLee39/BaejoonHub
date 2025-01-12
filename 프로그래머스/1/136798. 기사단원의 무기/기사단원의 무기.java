class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;  //필요한 철의 무게
        for(int i = 1; i<=number; i++){
            int num = 0; //약수의 개수
            for(int j=1; j*j <= i; j++){
                if(j*j==i){
                    num += 1;
                }else if(i%j==0){
                    num += 2;
                }
            }
            if(num>limit){
                num = power;
            }
            answer += num;
        }
        return answer;
    }
}