import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 오름차순 정렬
        
        long min = 1;
        // 최악의 경우는 가장 오래 걸리는 심사대에서 모든 심사를 받는 경우
        long max = (long) times[times.length-1] * n;
        long mid = 0;
        long sum;
    	long answer = max;
        
        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;
            
            for (int t : times) {
                sum += mid / t;
            }
            
            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}