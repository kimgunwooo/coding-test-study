/*
x,y축을 포함한 1사분면에서의 가능한 좌표만 고려하면 된다.
최대 1,000,000 까지 점을 찍을 수 있다.
0,0 + x축 + y축은 쉽게 구할 수 있다.
문제는 d*d 사각형 안에서 거리가 d 이하인 점들을 찾아야함.
쉽게 생각하면 점과 점사이 거리를 이용해서 비교? -> 최대 1,000,000 * 1,000,000 개 이기에 불가능.

피타고라스 정리로 높이 h값을 통해 비교 -> 한번의 반복문으로 해결 간으.
*/

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0;i<=d;i+=k){
            /*
            y값 계산.
            h^2 = d^2 + (k+i)^2
            Math.sqrt((long)d*d - (long)i*i) 를 통해서 i 번째의 h값을 구함.
            k로 나눔으로써 해당 i 번째 y축에 해당 값이 몇 개 존재하는지 확인.
            +1 을 통해서 y=0 일때도 추가.
            */
            answer += (int)Math.sqrt((long)d*d - (long)i*i) / k + 1;
        }
        
        return answer;
    }
}