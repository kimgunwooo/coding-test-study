import java.util.*;

/*
2중 for문 돌면 시간초과남.
오름차순 정렬하고

각 배열의 값들에 대해서
1 1 (같은 것) = 1
2 3 = 2/3
2 4 = 2/4 = 0.5
3 4 = 3/4 = 0.75
해당 값들이 map에 존재하는지 체크
존재한다면 result 값 증가

왜 Map? 중복 제거하려고
*/

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for (int i=0; i<weights.length; i++) {
            double[] temp = { 
                weights[i]*1.0,
                weights[i]*2.0/3.0,
                weights[i]*0.5,
                weights[i]*0.75};
            
            for (double t : temp) {
                if (map.containsKey(t)) {
                    result += map.get(t);
                }
            }
            
            map.put(weights[i]*1.0, map.getOrDefault(weights[i]*1.0, 0) + 1);
        }
        
        return result;
    }
}