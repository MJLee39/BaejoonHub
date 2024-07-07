import java.util.*;

class Solution {
    
    public boolean trueOrFalse(String begin, String word){
        boolean flag = false;
        for(int i=0; i<word.length(); i++){
            if(!flag && !begin.substring(i,i+1).equals(word.substring(i,i+1))){
                flag = true;
            }else if(flag && !begin.substring(i,i+1).equals(word.substring(i,i+1))){
                return false;
            }
        }
        return true;
    }
    
    public int bfs(String begin, String target, String[] words){
        int ans = 0;
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList<String>();
    
        queue.offer(begin);
        while(!queue.isEmpty()){ 
            ArrayList<String> str = new ArrayList<String>();
            while(!queue.isEmpty()){
                str.add(queue.poll());
            }
            for(String curr : str){
                if(curr.equals(target)){
                    return ans;
                }else{
                    for(int i=0; i<words.length; i++){
                        if(!visited[i] && trueOrFalse(curr, words[i])){
                            queue.offer(words[i]);
                            visited[i] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
}