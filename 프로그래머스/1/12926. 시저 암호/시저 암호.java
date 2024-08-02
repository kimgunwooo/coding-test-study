// s <= 8000
// 1<= n <= 25

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') { // 공백은 그대로
                answer += ' ';
                continue;
            }
            
            // 대문자, 소문자 구분
            int start = Character.isUpperCase(c) ? 'A' : 'a';
            int end = Character.isUpperCase(c) ? 'Z' : 'z';
            
            // 대문자, 소문자 각자에 해당하는 시작 아스키코드값을 빼서 1~26 사이 값으로 만듦 (c - start)
            // n 을 더한 값이 26을 넘으면 나머지 처리 후, 시작 아스키코드값을 더해서 원래 문자로 복구
            answer += (char) ((c - start + n) % 26 + start);
        }
        return answer;
    }
}