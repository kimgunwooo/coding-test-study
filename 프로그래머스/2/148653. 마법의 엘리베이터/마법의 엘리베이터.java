/*
1의 자리를 올림 또는 내림 가까운 쪽으로 0으로 만듬
10의자리

*/

class Solution {
    public int solution(int storey) {
        int count = 0;
        
        while (storey > 0) {
            int num = storey % 10;
            System.out.println(num);
            if (num < 5) {
                storey -= num;
                count += num;
            } else if (num > 5) {
                storey += (10 - num);
                count += (10 - num);
            } else {
                if ((storey / 10) % 10 < 5) {
                    storey -= 5;
                    count += 5;
                } else {
                    storey += 5;
                    count += 5;
                }
            }
            
            storey /= 10;
        }
        
        return count;
    }
}