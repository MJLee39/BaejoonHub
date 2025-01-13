import java.util.*;

class Solution {
    public long[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        long[] result = new long[size];

        for (long idx = left; idx <= right; idx++) {
            int row = (int) (idx / n);
            int col = (int) (idx % n);
            result[(int) (idx - left)] = (long)Math.max(row, col) + 1;
        }

        return result;
    }
}