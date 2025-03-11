import java.util.*;
/*
부분 수열 합 = k
그 중에서 가장 길이가 짧은 수열 구하기, 시작 인덱스가 작은 것으로
시작인덱스, 끝인덱스로 반환
---
투포인터 알고리즘으로 접근

*/

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[left];
        int min = 1_000_001;
        while (left <= right) {
            if (sum < k) {
                if (right+1 >= sequence.length) break;
                sum += sequence[++right];
            } else if (sum > k) {
                sum -= sequence[left++];
            }
            
            if (sum == k) {
                if (right-left+1 < min) {
                    answer[0] = left;
                    answer[1] = right;
                    min = right-left+1;
                }
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}