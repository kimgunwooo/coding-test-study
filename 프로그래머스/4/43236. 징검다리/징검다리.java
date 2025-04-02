import java.util.*;

// 2 11 14 17 21

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int l = 0;
        int r = distance; // 최대 거리
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (getRemoveRockCount(distance, rocks, mid) <= n) {
                answer = mid; // 만족하는경우. (최대값을 찾기위해 만족하는 가장 작은 수부터 찾음)
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return answer;
    }
    
    // 각 바위 사이의 거리 mid 를 기반으로 지운돌의 개수를 반환하는 메서드
    public int getRemoveRockCount(int distance, int[] rocks, int mid) {
        int count = 0; 
        int prev = 0;
        for (int i=0; i<rocks.length; i++) {
            if (rocks[i] - prev < mid) {
                count++;
            } else {
                prev = rocks[i];
            }
        }
        // 마지막 돌에서 도착지점까지 거리
        if (distance - prev < mid) {
            count++;
        }
        return count;
    }
}