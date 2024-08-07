class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        int[] location = new int[26];
        for (int i=0; i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (alpha[idx] == 0) {
                answer[i] = -1;
                location[idx] = i;
                alpha[idx]++;
            } else {
                answer[i] = i - location[idx];
                location[idx] = i;
            }
        }
        return answer;
    }
}