import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> participanter = new HashMap<>();
        
        for (String p : participant) {
            participanter.put(p, participanter.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            participanter.put(c, participanter.getOrDefault(c, 0) - 1);
        }
        
        for (String key : participanter.keySet()) {
            if (participanter.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}