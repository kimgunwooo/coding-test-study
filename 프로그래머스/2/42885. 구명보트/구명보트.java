import java.util.*;

/*
내림차순 정렬.
다음값을 보고 구명보트에 추가로 들어갈 수 있다면 
*/

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        
        int left = 0;
        int right = people.length - 1;
        while (left <= right && right >= 0) {
            int cur = limit - people[right];
            right--;
            if (cur - people[left] >= 0) {
                left++;
            }
        
            count++;
        }
        
        return count;
    }
}