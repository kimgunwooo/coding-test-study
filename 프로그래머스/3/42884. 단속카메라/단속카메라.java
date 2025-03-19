import java.util.*;
/*
20 15
      14  5
  18    13
          5 3
여기서 15(or 16,17,18), 5 지점에 설치하면 모두 겹침. -> 2개

정렬. 후, (-를 붙였다고 생각했을 때) 이전 차량의 나간 지점보다 다음 차량의 진입점이 작다면. 
*/

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o2[0] - o1[0]);
        
        int s = routes[0][0];
        int e = routes[0][1];
        int count = 1;
        
        for (int i = 1; i < routes.length; i++) {
            int curS = routes[i][0];
            int curE = routes[i][1];
            // System.out.println("s : " + s + " e : " + e);
            if (s > curE) {
                s = curS;
                e = curE;
                count++;
            } else {
                e = curE;
            }
        }
        // System.out.println("s : " + s + " e : " + e);
        return count;
    }
}