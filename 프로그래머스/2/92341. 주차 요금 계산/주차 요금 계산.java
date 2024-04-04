import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String,String> chart = new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[] car = records[i].split(" ");
            //System.out.println(Arrays.toString(car));
            if(car[2].length()==2){
                //IN
                chart.put(car[1], chart.getOrDefault(car[1], "0") +" "+ car[0]);
            }else{
                //OUT
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                    // 비교할 시간 (문자열) 
                    String timeStr1 = chart.get(car[1]).substring(chart.get(car[1]).length()-5,chart.get(car[1]).length());
                    String timeStr2 = car[0];

                    // 문자열 -> Date 
                    Date date1 = sdf.parse(timeStr1);
                    Date date2 = sdf.parse(timeStr2);

                    // Date -> 밀리세컨즈 
                    long timeMil1 = date1.getTime();
                    long timeMil2 = date2.getTime();

                    // 비교 
                    long diff = timeMil2 - timeMil1;

                    long diffMin = diff / (1000 * 60);

                    int diffMinUp = (int)diffMin;
                    //System.out.println("시간 차이(분) : " + diffMinUp + "분");
                    chart.put(car[1], Integer.toString(Integer.parseInt(chart.get(car[1]).substring(0,chart.get(car[1]).length()-6)) + diffMinUp));
                }catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        for(String num:chart.keySet()){
            if(chart.get(num).contains(" ")){
                //출차 안 찍힌 차
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                    // 비교할 시간 (문자열) 
                    String timeStr1 = chart.get(num).substring(chart.get(num).length()-5,chart.get(num).length());
                    String timeStr2 = "23:59";

                    // 문자열 -> Date 
                    Date date1 = sdf.parse(timeStr1);
                    Date date2 = sdf.parse(timeStr2);

                    // Date -> 밀리세컨즈 
                    long timeMil1 = date1.getTime();
                    long timeMil2 = date2.getTime();

                    // 비교 
                    long diff = timeMil2 - timeMil1;

                    long diffMin = diff / (1000 * 60);

                    int diffMinUp = (int)Math.ceil(diffMin);
                    //System.out.println("시간 차이(분) : " + diffMinUp + "분");
                    chart.put(num, Integer.toString(Integer.parseInt(chart.get(num).substring(0,chart.get(num).length()-6)) + diffMinUp));
                }catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("시간 결과 : " + chart);
        for(String num:chart.keySet()){
            //주차요금 계산
            if(Integer.parseInt(chart.get(num))<=fees[0]){
                //기본시간 미만
                chart.put(num,Integer.toString(fees[1]));
            }else{
                //기본시간 이상
                chart.put(num,Integer.toString(fees[1]+(int)Math.ceil((Integer.parseInt(chart.get(num))-fees[0])/(double)fees[2])*fees[3]));
            }
        }
        
        //System.out.println("결과 : " + chart);
        
        List<String> keySet = new ArrayList<>(chart.keySet());

        int[] answer = new int[keySet.size()];
        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        for (int i=0;i<keySet.size();i++) {
            answer[i] = Integer.parseInt(chart.get(keySet.get(i)));
        }
        return answer;
    }
}