import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        
        String prev = phone_book[0];
        for (int i=1; i<phone_book.length; i++) {
            String next = phone_book[i];
            int min = Math.min(prev.length(), next.length());
            
            boolean flag = true;
            for (int j=0; j<min; j++) {
                if (prev.charAt(j) != next.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) return false;
            prev = next;
        }
        
        return answer;
    }
}