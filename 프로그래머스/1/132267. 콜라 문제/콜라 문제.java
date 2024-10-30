class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int i = n/a;  //몫
        int j = n%a;  //나머지
        if(n>=a){
            answer += i*b;
            n = i*b+j;
            answer += solution(a, b, n);
        }
        return answer;
    }
}