import java.util.*;

/**
1 ≤ s ≤ 50
return 값이 1 이상 2,000,000,000 이하의 정수
영어 -> 숫자
*/

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for (String key : map.keySet()) {
            s = s.replaceAll(key, map.get(key));
        }
        int result = Integer.parseInt(s);
        return result;
    }
}