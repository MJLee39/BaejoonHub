class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int i = 0;  //cards1의 인덱스
        int j = 0;  //cards2의 인덱스
        for(int k=0;k<goal.length;k++){
            if(goal[k].equals(cards1[i])){
                System.out.println("1맞아"+i);
                if(i<cards1.length-1){
                    i += 1;
                }
            }else if(goal[k].equals(cards2[j])){
                System.out.println("2맞아"+j);
                if(j<cards2.length-1){
                    j += 1;
                }
            }else{
                answer = "No";
            }
        }
        
        return answer;
    }
}