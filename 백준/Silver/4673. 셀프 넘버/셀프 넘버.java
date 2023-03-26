public class Main {
    public static int d(int number){
        int sum = number;
        while(number!=0){
            sum += number%10;
            number = number/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        for(int i=1;i<10001;i++) {
            int n = d(i);
            if(n < 10001)
                check[n] = true;
        }
        for(int j=1;j<10001;j++){
            if(check[j]==false){
                System.out.println(j);
            }
        }
    }
}