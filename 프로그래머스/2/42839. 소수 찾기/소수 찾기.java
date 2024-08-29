import java.util.*;

/*
문자열 최대개수 7 에서 순열을 통해 모든 경우의 수를 파악해서, 소수인지 판별
최대 7! 에 소수판별 알고리즘을 제곱근 시간복잡도로 사용 -> 완전탐색
*/

class Solution {
    
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        for(int i=1;i<=numbers.length();i++){
            permutation(numbers.split(""), 0, numbers.length(), i);
        }
        return answer;
    }
    
    public void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            String temp = "";
            for(int i=0; i<r; i++){
                temp += arr[i];
            }
            if (isPrime(Integer.parseInt(temp))) {
                set.add(Integer.parseInt(temp));
                answer++;
            }
        }
        
        for (int i=depth;i<n;i++) { // 순열 알고리즘 기억
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
    
    public void swap(String[] arr, int depth, int i){
        String temp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = temp;
    }
    
    public boolean isPrime(int num) {
        if (set.contains(num)) return false; // 같은 숫자면 패스
        
        if (num < 2) return false;
        
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}