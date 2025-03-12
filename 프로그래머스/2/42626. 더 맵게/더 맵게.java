import java.util.*;
/*
음식 1,2 를 섞어서 새로운 스코빌 지수를 만든다.
(섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2))
모든 음식의 스코빌 지수가 K 이상으로 만들 최소 섞을 횟수
---
오름차순으로 정렬한다.
맨 위에 있는 값(최소값) 을 확인하고, K 이하라면 2개 꺼내서 섞고 넣는다.
최소값이 K 이상일 때 까지 반복한다.
*/

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int sc : scoville) {
            pq.offer((long) sc);
        }
        
        int count = 0;
        while (pq.peek() < K) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.offer(num1 + (num2 * 2));
            count++;
            
            if (pq.size() < 2 && pq.peek() < K){
                count = -1;
                break;
            }
        }
        
        return count;
    }
}