import java.time.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        // 1. LocalDate 생성
        LocalDate date = LocalDate.of(2016, a, b);
        // LocalDateTime date = LocalDateTime.of(2021, 12, 25, 1, 15, 20);
        //System.out.println(date);  // // 2021-12-25
 
        // 2. DayOfWeek 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();
 
        // 3. 숫자 요일 구하기
        int dayOfWeekNumber = dayOfWeek.getValue();
 
        // 4. 숫자 요일 출력
        //System.out.println(dayOfWeekNumber);  // 6
        
        if(dayOfWeekNumber==1){
            answer = "MON";
        }else if(dayOfWeekNumber==2){
            answer = "TUE";
        }else if(dayOfWeekNumber==3){
            answer = "WED";
        }else if(dayOfWeekNumber==4){
            answer = "THU";
        }else if(dayOfWeekNumber==5){
            answer = "FRI";
        }else if(dayOfWeekNumber==6){
            answer = "SAT";
        }else if(dayOfWeekNumber==7){
            answer = "SUN";
        }
        
        return answer;
    }
}