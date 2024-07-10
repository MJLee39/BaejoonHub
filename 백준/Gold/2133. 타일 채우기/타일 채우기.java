import java.io.*;

public class Main {
    
    public static int countTile(int n) {
        if (n % 2 != 0) {
            return 0; // n이 홀수인 경우 타일로 채울 수 없습니다.
        }

        int[] dp = new int[31]; // n의 최대값은 30이므로 크기를 31로 설정
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 2; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2; // 마지막 더하기 2
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        System.out.println(countTile(n));
    }
}
