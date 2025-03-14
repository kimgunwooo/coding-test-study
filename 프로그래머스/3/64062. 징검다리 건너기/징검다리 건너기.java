/*
작은수들이 없어지면서 0이되는 숫자의 범위가 k이상이 되면 건너지 못함
*/

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = 1;
        int r = 200_000_000;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (canCross(stones, k, mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;
        
        for (int stone : stones) {
            if (stone - mid < 0) {
                skip++;
            } else {
                skip = 0;
            }
            
            if (skip == k) {
                return false;
            }
        }
        
        return true;
    }
}