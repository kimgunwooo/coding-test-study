import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(temp, (o1, o2) -> (o2+o1).compareTo(o1+o2)); // 조합 자체를 비교
        
        for (String num : temp) {
            answer += num;
        }
        
        if (answer.charAt(0) == '0') return "0"; // 00000.. 처리
        
        return answer;
    }
}