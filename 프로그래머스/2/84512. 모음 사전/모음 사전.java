/*
word.length() <= 5
*/

class Solution {
    static int result = 0;
    static int count = 0;
    
    public int solution(String word) {
        dfs(word, "");
        return result;
    }
    
    public void dfs(String word, String temp) {
        if (result != 0) return;
        
        if (word.equals(temp)) {
            result = count;
        }
        count++;
        
        if (temp.length() == 5) return;
        
        dfs(word, temp + "A");
        dfs(word, temp + "E");
        dfs(word, temp + "I");
        dfs(word, temp + "O");
        dfs(word, temp + "U");
    }
}