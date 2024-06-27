import java.util.*;

class Solution {
    
    class SubClass {
        int index;
        String genre;
        int play;
        int maxPlay;
        
        SubClass(int index, String genre, int play, int maxPlay){
            this.index = index;
            this.genre = genre;
            this.play = play;
            this.maxPlay = maxPlay;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<String, Integer> maxMap = new HashMap<String, Integer>();  //max
        HashMap<String, Integer> map = new HashMap<String, Integer>(); //꺼낸거 표시
        ArrayList<SubClass> arr = new ArrayList<SubClass>();
        
        for(int i=0; i<genres.length; i++){
            if(maxMap.containsKey(genres[i])){
                maxMap.put(genres[i], maxMap.get(genres[i])+plays[i]);
            }else{
                maxMap.put(genres[i], plays[i]);
            }
        }
        
        for(int i=0; i<genres.length; i++){
            SubClass sc = new SubClass(i, genres[i], plays[i], maxMap.get(genres[i]));
            arr.add(sc);
        }
        
        Collections.sort(arr, new Comparator<SubClass>(){
            @Override
            public int compare(SubClass s1, SubClass s2){
                if(s1.maxPlay == s2.maxPlay){
                    if(s1.play == s2.play){
                        return s1.index - s2.index;
                    }
                    return s2.play - s1.play;
                }
                return s2.maxPlay - s1.maxPlay;
            }
        });
        
        for(int i=0; i<arr.size(); i++){
            if(map.containsKey(arr.get(i).genre)){
                if(map.get(arr.get(i).genre) < 2){
                    map.put(arr.get(i).genre, 2);
                    ans.add(arr.get(i).index);
                }
            }else{
                map.put(arr.get(i).genre, 1);
                ans.add(arr.get(i).index);
            }
        }
        answer = ans.stream().mapToInt(Integer :: intValue).toArray();
        return answer;
    }
}