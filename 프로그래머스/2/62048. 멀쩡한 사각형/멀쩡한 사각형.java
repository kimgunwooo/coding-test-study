/*
12, 8
(3, 2) (6, 4) (9, 6) (12, 8)
첫 값만 큼 늘어남
첫 값을 어떻게 찾음? -> 마지막 값(H,W)에서 /4
4는 어디서? -> H,W의 최대공약수

첫 값의 범위 안에서 걸리는 사각형의 개수는 어떻게?
x+y-1 라는 특징을 지님

x = H / gcd(H,W)
y = W / gcd(H,W)
result = H*W - (x+y-1)*gcd(H,W)
*/

class Solution {
    public long solution(int w, int h) {
        int num = gcd(w,h) > gcd(h,w) ? gcd(w,h) : gcd(h,w);
        return (long)h*w - (h/num + w/num -1) * num;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}