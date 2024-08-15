import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        
        
        for (int i=0; i<numbers.length; i++) {
            /*
            idx를 stack에 저장 (result 배열에 넣기 위해)
            numbers 배열에서 다음값이 큰 값이라면 stack에서 꺼낸 idx에 입력
            작은값이라면 stack에서 꺼내지 않음.
            */
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        return result;
    }
}