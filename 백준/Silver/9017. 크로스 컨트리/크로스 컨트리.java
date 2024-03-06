import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            Map<Integer, Integer> teams = new HashMap<>(); // 6명의 팀을 이루는지 체크할 맵
            int[] rank =  new int[n]; // 들어온 순서를 기록할 배열

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++) {
                int team = Integer.parseInt(st.nextToken());
                teams.put(team, teams.getOrDefault(team,0)+1);
                rank[j] = team;
            }

            Map<Integer,Integer> scoreMap = new HashMap<>();
            Map<Integer,Integer> tempMap = new HashMap<>();
            int[] fifthMember = new int[n+1];
            int score = 1;
            for(int team : rank) {
                if(teams.get(team) < 6) // 팀을 구성하지 못했다면 제외
                    continue;

                tempMap.put(team, tempMap.getOrDefault(team, 0)+1);

                if(tempMap.get(team) <= 4) { // 4등까지는 점수 계산
                    scoreMap.put(team, scoreMap.getOrDefault(team, 0)+score);
                }
                else if(tempMap.get(team) == 5){ // 비슷할때 비교할 5등 점수 저장
                    fifthMember[team] = score;
                }

                score++;
            }

            // 순위를 비교하기위한 정렬
            List<Integer> sorted = new ArrayList<>(scoreMap.keySet());
            sorted.sort((o1, o2) -> {
                if(Objects.equals(scoreMap.get(o1), scoreMap.get(o2)))
                    return fifthMember[o1] - fifthMember[o2];
                else
                    return scoreMap.get(o1) - scoreMap.get(o2);
            });

            sb.append(sorted.get(0)).append("\n");
        }
        System.out.println(sb);
    }
}
