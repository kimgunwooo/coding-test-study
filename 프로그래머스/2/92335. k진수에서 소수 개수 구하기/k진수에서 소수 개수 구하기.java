import java.util.*;
/*
1 ≤ n ≤ 1,000,000
3 ≤ k ≤ 10
*/

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }
        sb.reverse();
        
        StringTokenizer st = new StringTokenizer(sb.toString(), "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            
            if (num <= 1) continue;
            
            boolean flag = false;
            for (int i=2; i<(int)Math.sqrt(num)+1; i++) {
                if (num % i == 0) {
                    flag = true;
                    return 0;
                }
            }
            
            if (!flag) count++;
        }
        
        return count;
    }
}