import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        if(cacheSize==0){
            answer = cities.length*5;
        }else{
            for (String city:cities){
                city = city.toUpperCase();
                if (!cache.contains(city)){
                    // Miss!
                    if (cache.size() < cacheSize){
                        cache.add(city);
                    }else{
                        cache.remove(0);
                        cache.add(city);   
                    }
                    answer += 5;
                }else{
                    // Hit!
                    cache.remove(cache.indexOf(city));
                    cache.add(city);
                    answer+=1;
                }
            }   
        }
        return answer;
    }
}