import java.util.*;

/*
작업 소요시간 짧은 것 > 요청 시간 빠른 것 > 번호가 작은 것
선점방식.
마치는 시점에 바로 다음 일.

각 작업별 요청시각과 작업 종료 시각을 기록.
*/

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 순 정렬
        
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]); // 작업 소요시간 순 정렬
        
        int answer = 0;
        int count = 0;
        int idx = 0;
        int time = 0;
        while (count < jobs.length){
            while (idx < jobs.length && jobs[idx][0] <= time) {
                jobQueue.add(jobs[idx++]);
            }
            
            if (jobQueue.isEmpty()) {
                time = jobs[idx][0];
            }
            else{
                int[] curr = jobQueue.poll();
                time += curr[1];
                answer += time - curr[0];
                count++;
            }
            
        }
        
        return answer / jobs.length;
    }
}