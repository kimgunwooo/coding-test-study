import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int j=0;j<T;j++) {
            int result = 0;

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();

                double dist1 = Math.sqrt(Math.pow(x1-cx,2)+Math.pow(y1-cy,2));
                double dist2 = Math.sqrt(Math.pow(x2-cx,2)+Math.pow(y2-cy,2));

                if(!(dist1<r && dist2<r) && (dist1<r||dist2<r)) {
                    result++;
                }

            }
            System.out.println(result);
        }

    }
}