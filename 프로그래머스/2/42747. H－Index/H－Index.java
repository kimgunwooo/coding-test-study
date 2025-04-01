import java.util.*;

/*
중간 값 찾기?
0 1 3 5 6
0번이상 인용된 논문은 5편 이상 - 0
1번이상 인용된 논문은 4편 이상 - 1
3번이상 인용된 논문은 3편 이상 - 3
5번이상 인용된 논문은 2편 이상 - 2
6번잇아 인용된 논문은 1편 이상 - 1

0 1 4 5
0 - 4 = 0
1 - 3 = 1
4 - 2 = 2
5 - 1 = 1

5 6 7 8 ->> 4?
5 - 4 = 4
6 - 3 = 3
7 - 2 = 2
8 - 1 = 1


*/

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int cl = citations.length;
        int h = 0;
        
        // 최대 배열의 길이까지
        for (int i=0; i<cl; i++) {
            h = Math.max(h, Math.min(citations[i], cl-i));
        }
        
        return h;
    }
}