import java.util.*;

/*
1 <= N <= 9
1 <= number <= 32,000
괄호와 사칙연삼나 사용, 나누기에서 나머지는 무시.
정답이 8보다 크면 -1 return

---

N이 주어질 때,
1~8 까지 N을 몇 번 사용해서 어떤 값이 나오는지 저장하고 있는다.
ex) 
1 -> 자기자신만
2 -> 1+1
3 -> 2+1, 1+2

5
1 - 5
2 - 5+5, 5-5, 5/5, 5*5, 55
3 - dp(1) + dp(2), ...
4 - dp(3) + dp(1)


*/

class Solution {
    public static List<Set<Integer>> dp = new ArrayList<>();
    
    public int solution(int N, int number) {
        for (int i=0; i<9; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N); // 1로 만들 수 있는 것은 N 자기 자신
        
        for (int i=2; i<9; i++) {
            Set<Integer> set = dp.get(i); // 2~8 까지 DP 배열 업데이트
            
            for (int j=1; j<=i; j++) { // i를 만들 수 있는 모든 경우의 수 계산
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i-j);
                
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if (preNum == 0 || postNum == 0) continue; // 0으로 나누기 체크
                        set.add(preNum / postNum);
                    }
                }
                set.add(Integer.parseInt(String.valueOf(N).repeat(i))); // ex) 55, 555
            }
        }
        
        // 검증 단계. 존재한다면 해당 List의 인덱스 위치 반환
        for (Set<Integer> sub : dp) {
            if (sub.contains(number)) return dp.indexOf(sub);
        }
        
        return -1;
    }
}