class Solution {
	// public int pebo(int n) {
	// 	if (n == 1)
	// 		return 1%1234567;
	// else if (n == 2)
	// return 2%1234567;
	// 	else 
	// 		return pebo(n-1)%1234567+pebo(n-2)%1234567;
	// }
    
    public long solution(int n) {
        long[] d = new long[n + 1];
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        d[0] = 0;
        d[1] = 1L;
        d[2] = 2L;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1234567;
        }

        return d[n];
    }
}