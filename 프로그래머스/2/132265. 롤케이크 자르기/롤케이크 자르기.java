import java.util.*;

/*
1 ≤ topping의 길이 ≤ 1,000,000
1 ≤ topping의 원소 ≤ 10,000
[1, 2, 1, 3, 1, 4, 1, 2]

1 2 2 3 3 4 4 4
4 4 4 4 3 3 2 1
*/

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] right = new int[topping.length];
        int[] left = new int[topping.length];
        int result = 0;
        
        for (int i=0; i<topping.length; i++) {
            map.put(topping[i], 0);
            left[i] = map.size();
        }
        map.clear();
        for (int i=topping.length-1; i>=0; i--) {
            map.put(topping[i], 0);
            right[i] = map.size();
        }
        for (int i=0; i<topping.length -1; i++) {
            if (left[i] == right[i+1])
                result++;
        }
        
        return result;
    }
}