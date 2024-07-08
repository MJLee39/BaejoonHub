import java.util.*;

class Solution {

    public boolean dfs(String[][] tickets, boolean[] visited, ArrayList<String> answer, String curr, int count){
        answer.add(curr);
        if(count == tickets.length){
            return true;
        }
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(curr) && !visited[i]){
                visited[i] = true;
                if(dfs(tickets, visited, answer, tickets[i][1], count + 1)){
                    return true;
                }
                visited[i] = false;
            }
        }
        answer.remove(answer.size() - 1);
        return false;
    }

    public ArrayList<String> solution(String[][] tickets) {
        ArrayList<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        // Sort the tickets array based on the departure and arrival locations
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs(tickets, visited, answer, "ICN", 0);
        return answer;
    }
}