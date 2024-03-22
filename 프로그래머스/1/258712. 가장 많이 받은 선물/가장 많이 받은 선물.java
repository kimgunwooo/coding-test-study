import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> relation = new HashMap<>();
        Map<String, Integer> give = new HashMap<>();
        Map<String, Integer> take = new HashMap<>();
        
        // 초기화
        for(String str : friends) {
            relation.put(str, new HashMap<>());
            give.put(str, give.getOrDefault(str,0));
            take.put(str, take.getOrDefault(str,0));
        }
        
        for(String str : gifts) {
            StringTokenizer st = new StringTokenizer(str," ");
            String from = st.nextToken();
            String to = st.nextToken();
            // 총 주고 받은 선물
            give.put(from, give.getOrDefault(from,0)+1);
            take.put(to, take.getOrDefault(to,0)+1);
            // 관계 from - (to, 수)
            int cnt = relation.get(from).getOrDefault(to, 0);
            relation.get(from).put(to, cnt+1);
        }
        
        for(int i=0;i<friends.length;i++){
            int count = 0;
            for(int j=0;j<friends.length;j++) {
                if(i==j) continue;
                
                String now = friends[i];
                String temp = friends[j];
                System.out.print("now temp : "+now + " " + temp + "\n");
                // 다른 사람과 준 선물 개수 비교
                int a = relation.get(now).getOrDefault(temp, 0);
                int b = relation.get(temp).getOrDefault(now, 0);
                // 선물 지수 계산
                int giftA = give.get(now) - take.get(now);
                int giftB = give.get(temp) - take.get(temp);
                System.out.print("a b : "+a + " " + b + "\n");
                System.out.print("giftA giftB : "+giftA + " " + giftB + "\n");
                if(a > b)
                    count++;
                else if ((a == 0 && b==0) || (a == b)) { // 주고받은 적이 없거나 같으면 선물 지수로 비교
                    if(giftA > giftB)
                        count++;
                }
                System.out.print("count : "+count + "\n");
            }
            System.out.print("\n");
            answer = Math.max(count,answer);
        }
        
        return answer;
    }
}