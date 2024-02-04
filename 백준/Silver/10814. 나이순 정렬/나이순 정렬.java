import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Member{
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    static List<Member> members = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
            members.add(member);
        }

        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age) {
                    return 0;
                }
                return o1.age - o2.age;
            }
        });

        for(Member m : members) {
            System.out.print(m.age + " " + m.name);
            System.out.println();
        }
    }


    private static void solution() {

    }
}
