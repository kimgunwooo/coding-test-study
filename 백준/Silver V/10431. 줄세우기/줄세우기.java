import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sb.append(st.nextToken()).append(" ");

            LinkedList<Integer> students = new LinkedList<>();
            for(int j=0;j<20;j++) {
                students.add(Integer.parseInt(st.nextToken()));
            }

            int result = Sort(students);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int Sort(LinkedList<Integer> students) {
        int result=0;
        for(int i=1;i<20;i++) {
            for(int j=0;j<i;j++){
                if(students.get(j) > students.get(i)){
                    int temp = students.remove(i);
                    students.add(j, temp);
                    result += i-j;
                    break;
                }
            }
        }
        return result;
    }
}
