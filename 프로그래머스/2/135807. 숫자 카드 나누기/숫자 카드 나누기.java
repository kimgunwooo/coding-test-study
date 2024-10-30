/*
각 배열 안에서 최대공약수를 찾는다.
있으면 해당 수로 상대 배열을 돌면서 나누어 떨어지는 수가 있는지 체크
없으면 0으로 반복문을 돌지않음.
각 배열에서 최대공약수가 둘 다 존재한다면 그 중에서 최대값 반환
*/

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int result = 0;
        boolean aPlag = false; // 나누어 떨어지는지 체크
        boolean bPlag = false;
        int aGcd = gcd(arrayA) == 1 ? 0 : gcd(arrayA);
        System.out.println(aGcd);
        int bGcd = gcd(arrayB) == 1 ? 0 : gcd(arrayB);
        System.out.println(bGcd);
        
        if (aGcd != 0) {
            for (int a : arrayB) {
                if (a % aGcd == 0) {
                    aPlag = true;
                    break;
                }
            }
        }
        
        if (bGcd != 0) {
            for (int b : arrayA) {
                if (b % bGcd == 0) {
                    bPlag = true;
                    break;
                }
            }
        }
        
        if (!aPlag) {
            result = Math.max(result, aGcd);
        }
        
        if (!bPlag) {
            result = Math.max(result, bGcd);
        }
        
        
        return result;
    }
    
    public int gcd(int[] ary) {
        int temp = ary[0];
        for (int i=1; i<ary.length; i++) {
            temp = gcd(temp, ary[i]);
        }
        return temp;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}