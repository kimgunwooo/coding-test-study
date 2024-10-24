import java.util.*;
import java.util.stream.*;
/**
최종합/2 를 통해 target 값을 찾음.
한 큐 에서 target 값 만들기가 가능하다면 바로 return
종료 조건은? 어느 한 큐에서 empty 가 되었을때?

*/

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] arr = IntStream.concat(Arrays.stream(queue1), Arrays.stream(queue2)).toArray();
        long q1Sum = 0;
        long q2Sum = 0;
        
        for (int i=0; i<queue1.length; i++) {
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        long target = (q1Sum + q2Sum) / 2;
        int result = -1;
        int count = 0;
        int q1Index = 0;
        int q2Index = queue1.length;
        while ((q1Sum != 0 && q2Sum != 0) && (q1Index < arr.length && q2Index < arr.length) && (q1Index != q2Index)) {
            if (q1Sum < q2Sum) {
                int temp = arr[q2Index];
                q2Sum -= temp;
                q1Sum += temp;
                q2Index++;
            } else if (q1Sum > q2Sum) {
                int temp = arr[q1Index];
                q1Sum -= temp;
                q2Sum += temp;
                q1Index++;
            } else if (q1Sum == q2Sum) {
                result = count;
                break;
            }
            
            count++;
        }
        
        return result;
    }
}