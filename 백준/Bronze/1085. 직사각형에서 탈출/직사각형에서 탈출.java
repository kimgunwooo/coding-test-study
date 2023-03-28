import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] num = new int[4];
        StringTokenizer st = new StringTokenizer(n);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        num[0] = x;
        num[1] = y;
        num[2] = w-x;
        num[3] = h-y;

        //x, y, w-x, h-y 여기의 최소값 찾기
        Arrays.sort(num);
        System.out.println(num[0]);
    }
}
