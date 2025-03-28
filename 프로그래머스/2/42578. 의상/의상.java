import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            String item = c[0];
            String type = c[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            // 그 종류의 의상을 안입는 경우도 포함하기에 +1
            answer *= map.get(key) + 1;
        }
        
        // 아무것도 안입은 경우 -1
        return answer - 1;
    }
}