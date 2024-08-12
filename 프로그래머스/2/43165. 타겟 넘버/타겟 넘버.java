/*
numbers <= 20
작기에 dfs 사용 가능.
*/

class Solution {
    public static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int result = dfs(numbers, 0, 0, target);
        
        return result;
    }
    
//     public void dfs(int[] numbers, int idx, int value, int target) {
//         if (numbers.length == idx) {
//             if (value == target)
//                 count++;
//             return;
//         }
        
//         dfs(numbers, idx + 1, value + numbers[idx], target);
//         dfs(numbers, idx + 1, value - numbers[idx], target);
//     }
    
    public int dfs(int[] numbers, int idx, int value, int target) {
        if (numbers.length == idx) {
            if (value == target)
                return 1;
            return 0;
        }
        
        return dfs(numbers, idx + 1, value + numbers[idx], target) + 
            dfs(numbers, idx + 1, value - numbers[idx], target);
    }
}