import java.util.*;

class Solution {
    public static int min = Integer.MAX_VALUE;
    public static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0; // target이 존재하지 않으면 0
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            min = Math.min(min, depth);
            // System.out.println("찾았다!! : " + target + " depth : " + depth);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            if (countingDiffNum(words[i], begin) != 1) continue;
            
            if (visited[i]) continue;
            
            visited[i] = true;
            // System.out.println("방문 : " + words[i]);
            dfs(words[i], target, words, depth+1);
            visited[i] = false;
        }
    }
    
    // 두 문자열의 다른 문자의 개수를 반환하는 함수
    public int countingDiffNum(String a, String b) {
        int len = a.length(); // 두 문자열의 길이는 같음
        int count = 0;
        for (int i=0; i<len; i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}