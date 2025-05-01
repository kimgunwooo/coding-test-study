
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
 
        for (int i = 0 ; i < len-1 ; i++) {
            for(int j = i+1 ; j < len ; j++) {
                answer[i]++;
                // 낮은 수가 나왔다면 종료
                if(prices[i] > prices[j]) break;
            }
        }
 
        // 고정 값
        answer[len-2] = 1;
        answer[len-1] = 0;
 
        return answer;
    }
}