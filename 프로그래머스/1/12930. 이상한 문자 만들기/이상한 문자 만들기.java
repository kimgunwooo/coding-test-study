import java.util.*;

// 각 단어의 짝수번째 알파벳을 대문자로, 홀수번째 알파벳은 소문자로

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] list = s.split("");
        int cnt = 0;
        
        for (String str : list) {
            cnt = str.contains(" ") ? 0 : cnt + 1;
            answer += (cnt%2 == 0) ? str.toLowerCase() : str.toUpperCase(); 
        }
        
        return answer;
    }
}