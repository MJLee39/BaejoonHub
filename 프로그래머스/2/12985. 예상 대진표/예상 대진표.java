class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        a=a-1;
        b=b-1;
        while(a/2!=b/2){
            a=a/2;
            b=b/2;
            answer+=1;
        }
        // int max = a;
        // int min = b;
        // if(a<b){
        //     max = b;
        //     min = a;
        // }
        // while(max>1){
        //     if(min%2 !=0){
        //         min = min+1;
        //     }
        //     if(max%2 != 0){
        //         max = max+1;
        //     }
        //     min = min/2;
        //     max = max/2;
        //     answer++;
        //     if(max-min==1 && max%2==0){
        //         answer++;
        //         break;
        //     }
        // }    
        return answer;
    }
}