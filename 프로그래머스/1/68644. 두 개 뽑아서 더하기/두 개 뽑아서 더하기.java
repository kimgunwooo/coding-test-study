import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                map.put(numbers[i] + numbers[j], 0);
            }
        }
        for (int key : map.keySet()) {
            temp.add(key);
        }
        Collections.sort(temp);
        int[] result = new int[temp.size()];
        for (int i=0; i<temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}