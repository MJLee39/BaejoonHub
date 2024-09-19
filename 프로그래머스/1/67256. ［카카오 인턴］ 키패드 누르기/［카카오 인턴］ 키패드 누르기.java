import java.lang.Math;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 0;
        int right = 20;
        int where = 0;
        String hands = "";
        if(hand.equals("right")){
            hands = "R";
        }else{
            hands = "L";
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1){
                answer += "L";
                left = 3;
            }else if(numbers[i]==4){
                answer += "L";
                left = 2;
            }else if(numbers[i]==7){
                answer += "L";
                left = 1;
            }else if(numbers[i]==3){
                answer += "R";
                right = 23;
            }else if(numbers[i]==6){
                answer += "R";
                right = 22;
            }else if(numbers[i]==9){
                answer += "R";
                right = 21;
            }else if(numbers[i]==2){
                where = 13;
                if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))>(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += "R";
                    right = where;
                }else if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))==(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += hands;
                    if(hands.equals("R")){
                        right = where;
                    }else{
                        left = where;
                    }
                }else{
                    answer += "L";
                    left = where;
                }
            }else if(numbers[i]==5){
                where = 12;
                if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))>(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += "R";
                    right = where;
                }else if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))==(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += hands;
                    if(hands.equals("R")){
                        right = where;
                    }else{
                        left = where;
                    }
                }else{
                    answer += "L";
                    left = where;
                }
            }else if(numbers[i]==8){
                where = 11;
                if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))>(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += "R";
                    right = where;
                }else if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))==(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += hands;
                    if(hands.equals("R")){
                        right = where;
                    }else{
                        left = where;
                    }
                }else{
                    answer += "L";
                    left = where;
                }
            }else if(numbers[i]==0){
                where = 10;
                if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))>(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += "R";
                    right = where;
                }else if((Math.abs(left/10-where/10)+Math.abs(left%10-where%10))==(Math.abs(right/10-where/10)+Math.abs(right%10-where%10))){
                    answer += hands;
                    if(hands.equals("R")){
                        right = where;
                    }else{
                        left = where;
                    }
                }else{
                    answer += "L";
                    left = where;
                }
            }
        }
        return answer;
    }
}