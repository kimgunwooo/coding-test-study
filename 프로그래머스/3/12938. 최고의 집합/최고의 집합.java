import java.util.*;

/*
n개로 이루어진 집합. 해당 집합의 합은 s
여러개가 존재한다면 그 중에서 집합 원소의 곱이 최대인 집합 찾기 (오름 차순 정렬)

3, 9
1 2 6
1 3 5
1 4 4
2 2 5
2 3 4
3 3 3

*/

class Solution {
    public int[] solution(int n, int s) {
        
        if (s < n) return new int[] {-1};
        
        int[] answer = new int[n];
        
        int cnt = s / n;
        int temp = s % n;
        for (int i = 0; i < n; i++) {
            if (i >= n - temp) answer[i] = cnt + 1;
            else answer[i] = cnt;
        }
        
        return answer;
    }
}