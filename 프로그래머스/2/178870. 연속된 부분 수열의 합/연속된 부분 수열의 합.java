/**

*/

class Solution {
    public static int maxIndex;
    public static int minIndex;
    
    public int[] solution(int[] sequence, int k) {
        return this.findPartialSequence(sequence, k);
    }
    
    public int[] findPartialSequence(int[] sequence, int k) {
        maxIndex = 0;
        minIndex = 0;
        int sum = sequence[0];
        int length = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        while (true) {
            if (sum > k) {
                sum -= sequence[minIndex];
                minIndex++;
            } else if (sum < k) {
                if (maxIndex + 1 >= sequence.length) {
                    break;
                }
                maxIndex++;
                sum += sequence[maxIndex];
            } else {
                if (maxIndex - minIndex < length) {
                    result[0] = minIndex;
                    result[1] = maxIndex;
                    length = maxIndex - minIndex;
                }
                sum -= sequence[minIndex];
                minIndex++;
            }
        }
        
        return result;
    }
}