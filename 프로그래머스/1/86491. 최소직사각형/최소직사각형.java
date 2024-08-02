import java.util.*;
// 각 행에서 오름차순으로 정렬해 작은값은 0번열, 큰 값은 1번 열
// 각 열에서 최대값을 구해서 곱함
// sizes <= 10_000 

// [[60, 50], 50, 60
//  [30, 70], 30, 70
//  [60, 30], 30, 60
//  [80, 40]] 40, 80

// [[10, 7], 7, 10
//  [12, 3], 3, 12
//  [8, 15], 8, 15
//  [14, 7], 7, 14
//  [5, 15]] 5, 15

// [[14, 4], 
//  [19, 6], 
//  [6, 16], 
//  [18, 7], 
//  [7, 11]]

class Solution {
    public int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for (int i=0; i<sizes.length; i++) { // 각 행 오름차순 정렬
            Arrays.sort(sizes[i]);
        }
        
        for (int i=0; i<sizes.length; i++) {
            if (maxW < sizes[i][0])
                maxW = sizes[i][0];
            if (maxH < sizes[i][1])
                maxH = sizes[i][1];
        }
        
        return maxW * maxH;
    }
}