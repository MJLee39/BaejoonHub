class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        //최대공약수
        int max = 1;
        for(int i=n;i>=1;i--){
            if(n%i==0){
                max = i;
                //System.out.println(max);
                if(m%max==0){
                    answer[0] = max;
                    answer[1] = (n/max)*(m/max)*max;
                    break;
                }
            }
        }
        return answer;
    }
}