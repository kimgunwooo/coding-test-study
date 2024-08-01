// 중복 없이 최대 13개 중 3개 뽑기
// 13 12 11 / 3 2 

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i=0; i<number.length; i++) {
            for (int j=i+1; j<number.length; j++) {
                for (int k=j+1; k<number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}