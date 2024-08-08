
// a : b 
class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        
        while (n >= a) {
            int temp = n / a;
            n = n - (temp * a) + (temp * b);
            result += temp * b;
        }
        
        return result;
    }
}