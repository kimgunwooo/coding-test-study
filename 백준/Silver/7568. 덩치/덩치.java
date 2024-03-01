import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person{
    int x;
    int y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people.add(new Person(x,y));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int rank = 1;
            for(int j=0;j<n;j++) {
                if(i==j)
                    continue;
                // 나보다 덩치가 작은 사람이 있으면 내 rank를 증가
                if((people.get(i).x < people.get(j).x) && (people.get(i).y < people.get(j).y))
                    rank++;
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}


