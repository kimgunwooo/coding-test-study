import java.util.Scanner;
public class Main {
    public static int d(int number){
        int check[] = new int[number+1];
        int count =0;
        if(number<100)
            return number;
        else {
            count = 99;
            for (int i = 100; i <= number; i++) {
                int bak = i/100;
                int sip = (i/10)%10;
                int ill = i%10;
                if((bak-sip) == (sip-ill))
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(d(n));
    }
}