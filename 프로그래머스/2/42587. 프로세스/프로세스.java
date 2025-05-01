import java.util.*;

// 높은거부터 

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int solution(int[] priorities, int location) {
        for (int p : priorities) {
            pq.offer(p);
        }
        
        
        int i=0;
        int count = 0;
        while (priorities[location] != 0) {
            
            if (priorities[i] == pq.peek()) {
                pq.poll(); // 제거
                priorities[i] = 0;
                count++;
            }
            
            i = (i+1) % priorities.length;
        }
        
        return count;
    }
}