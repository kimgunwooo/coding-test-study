import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        int[] answer = new int[2];
        
        for (String operation : operations) {
            String[] ops = operation.split(" ");
            String op = ops[0];
            int num = Integer.parseInt(ops[1]);
            
            if (op.equals("I")) {
                maxPQ.offer(num);
                minPQ.offer(num);
            } 
            else if (op.equals("D")) {
                if (maxPQ.isEmpty() || minPQ.isEmpty()) continue;
                
                if (num == 1) {
                    int max = maxPQ.poll();
                    minPQ.remove(max);
                }
                else if (num == -1) {
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            }
        }
        
        if (maxPQ.isEmpty() || minPQ.isEmpty()) return new int[]{0,0};
        else return new int[]{maxPQ.peek(), minPQ.peek()};
    }
}