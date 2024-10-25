import java.util.*;

/*
최대 크기 100x100
init : 1~n*m 까지의 초기값
최대 회전 개수 10_000

회전이 연속적으로 이루어지기에 실제 배열에서 옮기는 작업이 필요.
또한 어떻게 그 안에서 최소값을 찾을지 고민.
어떻게 효율적으로?
[2,2,5,4]
2,2 -> 2,3 -> 2,4 -> 3,4 -> 4,4 -> 5,4 -> 5,3 -> 5,2 -> 4,2 -> 3,2 -> 2,2
해당 값들을 stack에 넣고, 빼면서 업데이트 - 최소값을 비교
*/

class Solution {
    public class Point {
        int i;
        int j;
        int value;
        
        public Point(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        int[][] metrix = new int[rows+1][columns+1];
        int temp = 1;
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                metrix[i][j] = temp++;
            }
        }
        
        for (int[] query : queries) {
            if (queries.length == 1) {
                result.add(metrix[query[0]][query[1]]);
                break;
            }
            
            int si = query[0];
            int sj = query[1];
            int ei = query[2];
            int ej = query[3];
            
            //초기 설정
            Stack<Point> stack = new Stack<>();
            stack.push(new Point(si, sj, metrix[si][sj]));
            int min = metrix[si][sj]; 
            String command = "RIGHT"; // RIGHT, DOWN, LEFT, UP, STOP
            
            while(!stack.isEmpty()) {
                Point p = stack.pop();
                if (command.equals("STOP")) break;
                
                int mi = p.i;
                int mj = p.j;
                int value = p.value;
                switch (command) {
                    case "RIGHT": 
                        mj++;
                        if (mj == ej) command = "DOWN";
                        break;
                    case "DOWN":
                        mi++;
                        if (mi == ei) command = "LEFT";
                        break;
                    case "LEFT":
                        mj--;
                        if (mj == sj) command = "UP";
                        break;
                    case "UP":
                        mi--;
                        if (mi == si) command = "STOP";
                        break;
                }
                min = Math.min(min, value); // 최소 값 업데이트
                stack.push(new Point(mi, mj, metrix[mi][mj])); // 다음 탐색 값 push
                metrix[mi][mj] = value; // 다음 값을 이전 값으로 업데이트
            }
            // this.print(rows, columns, metrix);
            result.add(min);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void print(int rows, int columns, int[][] metrix) {
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                System.out.print(metrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}