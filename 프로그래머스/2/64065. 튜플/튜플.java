import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("\\},\\{");
        int[] answer = new int[arr.length];
        arr[0]=arr[0].substring(2);
        arr[arr.length-1]=arr[arr.length-1].substring(0,arr[arr.length-1].length()-2);
        //배열의 문자열의 길이를 기준으로 오름차순으로 정렬
        Arrays.sort(arr , (s1,s2) -> s1.length()-s2.length());
        
        //이차배열에 담기
        String[][] sortedByLength = new String[arr.length][];
        for (int i = 0 ; i < arr.length ; i++) {
            String[] ss = arr[i].split(",");
            sortedByLength[ss.length-1] = ss;
        }    
        
        // set에 요소를 담으면서, set에 없었던 요소이면 answerStrArr에 추가
        HashSet<String> mySet = new HashSet<>();
        String[] answerStrArr = new String[arr.length];
        for (int i = 0 ; i < sortedByLength.length ; i++) {
            for (int j = 0 ; j < sortedByLength[i].length ; j++) {
                if (!mySet.contains(sortedByLength[i][j])) {
                    answerStrArr[i] = sortedByLength[i][j];
                    mySet.add(sortedByLength[i][j]);
                }
            }
        }
        System.out.println(Arrays.toString(answerStrArr));
        for(int i=0;i<answerStrArr.length;i++){
            answer[i] = Integer.parseInt(answerStrArr[i]);
        }
        
        //런타임 에러나는 코드
        // answer[0] = Integer.parseInt(arr[0]);
        // for(int i=1;i<arr.length;i++){
        //     for(int j=0;j<i;j++){
        //         arr[i] = arr[i].replace(arr[i-1-j],"");
        //     }
        //     arr[i] = arr[i].replaceAll(",","");
        //     answer[i] = Integer.parseInt(arr[i]);
        // }
        
        return answer;
    }
}