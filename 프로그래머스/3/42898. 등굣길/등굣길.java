import java.util.*;

class Solution {
   
    public int dp(int cur_n, int cur_m, int[][] newPuddles, int[][] memo){
        // 경계 조건
        if (cur_n < 1 || cur_m < 1 || newPuddles[cur_n][cur_m] == 1) {
            return 0;  // 웅덩이거나 범위를 벗어나면 0 반환
        }
        
        // 시작 지점에 도달하면
        if (cur_n == 1 && cur_m == 1) {
            return 1;
        }
        
        // 이미 계산된 경우
        if (memo[cur_n][cur_m] != -1) {
            return memo[cur_n][cur_m];
        }

        // 상단과 좌측에서 오는 경우를 더함
        memo[cur_n][cur_m] = (dp(cur_n - 1, cur_m, newPuddles, memo) 
                            + dp(cur_n, cur_m - 1, newPuddles, memo)) % 1000000007;
        return memo[cur_n][cur_m];
    }
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] memo = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);  // 초기화: -1은 아직 계산되지 않음을 의미
        }

        int[][] newPuddles = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            newPuddles[puddle[1]][puddle[0]] = 1;  // 웅덩이 위치 설정
        }

        return dp(n, m, newPuddles, memo);
    }
}