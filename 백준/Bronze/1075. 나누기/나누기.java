import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int temp = n / 100 * 100;
        while(true) {
            int result = temp % f;
            if (result == 0) {
                System.out.printf("%02d",temp%100);
                break;
            } else {
                temp++;
            }
        }
    }
}