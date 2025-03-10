
class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] sumList = new long[n + 1];

        // 누적합 계산
        for (int i = 0; i < n; i++) {
            sumList[i + 1] = sumList[i] + 
                ((i % 2 == 0) ? sequence[i] : -sequence[i]);
        }

        // 최대값과 최소값 찾기
        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        for (long num : sumList) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }

        return Math.abs(maxVal - minVal);
    }
}