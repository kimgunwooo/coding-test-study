import java.util.*;
/*
이전 progresses가 끝나야 다음 프로세스가 가능
93,1 -> 7
30,30 -> 3
55,5 -> 9

7 -> 2
9 -> 1

95,1 -> 5
90,1 -> 10
99,1 -> 1
99,1 -> 1
80,1 -> 20
99,1 -> 1

1, 3, 2
*/

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int day = (100-progress) / speed;
            if ((100-progress) % speed != 0) day++;
            
            queue.offer(day);
        }
        
        List<Integer> resultList = new ArrayList<>();
        int idx = 1;
        int pre = queue.poll();
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (next > pre) {
                resultList.add(idx);
                idx = 1;
                pre = next;
            } else {
                idx++;
            }
        }
        resultList.add(idx);
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}