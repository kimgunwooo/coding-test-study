import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] switches = new int[n+1];
        for(int i=1;i<=n;i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());

        for(int i=0;i<student;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            int temp = number;
            if(gender == 1) { // 남자인 경우
                while (temp <= n) {

                    switches[temp] = switches[temp] == 0 ? 1 : 0;
                    temp += number;
                }
            }
            else if(gender == 2) { // 여자인 경우
                switches[number] = switches[number] == 0 ? 1 : 0;

                int size = 1;
                while(true) {
                    int prev = number - size;
                    int next = number + size;

                    if(prev < 1 || next > n) break;

                    if(switches[prev] == switches[next]){
                        switches[prev] = switches[prev] == 0 ? 1 : 0;
                        switches[next] = switches[next] == 0 ? 1 : 0;
                        size++;
                    }
                    else break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            sb.append(switches[i]).append(" ");
            if(i==20 || i==40 || i==60 || i==80){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
