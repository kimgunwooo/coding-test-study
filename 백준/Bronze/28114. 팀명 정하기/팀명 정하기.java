import java.io.*;
import java.util.*;

/*
2초, 1024MB
---
1. 년도는 오름차순으로 100으로 나눈 나머지를 이어 붙여서 출력
2. 문제 해결 수 - 이름 앞글자 쌍으로 문제 해결수가 많은거 부터 이름 앞글자 따와서 출력
---
1 < 문자열 길이 < 1000

*/
class Member implements Comparable<Member>{
    int solve;
    char firstName;
    public Member(int solve, char firstName) {
        this.firstName = firstName;
        this.solve = solve;
    }
    public int compareTo(Member o) {
        return o.solve - this.solve;
    }
}

public class Main {
    public static int m, n, T;
    public static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] years = new int[3];
        Member[] members = new Member[3];

        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int solve = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            years[i] = year%100;
            members[i] = new Member(solve, name.charAt(0));
        }

        Arrays.sort(years);
        Arrays.sort(members);

        for (int year : years) {
            sb.append(year);
        }
        sb.append("\n");
        for (Member m : members) {
            sb.append(m.firstName);
        }
        System.out.println(sb);
    }
}