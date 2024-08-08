import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[score.length];
        
        for (int i=0; i<score.length; i++) {
            if (i < k) {
                pq.add(score[i]);
            } else {
                pq.add(score[i]);
                pq.remove();
                
            }
            result[i] = pq.peek();
        }
        
        return result;
    }
}