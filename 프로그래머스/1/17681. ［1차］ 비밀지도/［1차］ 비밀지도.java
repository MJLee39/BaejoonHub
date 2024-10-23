import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] answer_1 = new String[n];
        String binaryString ="";
        String[] temp = new String[n];
        String[][] arr1_1 = new String[n][n];
        String[][] arr2_2 = new String[n][n];
        for(int i=0;i<arr1.length;i++){
            binaryString = Integer.toBinaryString(arr1[i]);
            while(binaryString.length()<n){
                binaryString = "0"+binaryString;
            }
            temp = binaryString.split("");
            for(int j=0; j<n; j++){
                arr1_1[i][j] = temp[j];
            }
        }
        for(int i=0;i<arr2.length;i++){
            binaryString = Integer.toBinaryString(arr2[i]);
            while(binaryString.length()<n){
                binaryString = "0"+binaryString;
            }
            temp = binaryString.split("");
            for(int j=0; j<n; j++){
                arr2_2[i][j] = temp[j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr1_1[i][j].equals("0") && arr2_2[i][j].equals("0")){
                    answer_1[i] += " ";
                }else{
                    answer_1[i] += "#";
                }
                answer[i] = answer_1[i].replace("null", "");
            }
        }
        return answer;
    }
}