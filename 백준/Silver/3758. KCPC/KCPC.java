import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 100 * 10000
 */


public class Main {
	public static int T;
	public static int n,k,t,m;
	public static int[][] scores;
	public static int[] counts;
	public static int[] times;
	public static ArrayList<Team> teams;

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;

	public static class Team implements Comparable<Team> {
		int id;
		int score;
		int count;
		int time;

		public Team(int id, int score, int count, int time) {
			this.id = id;
			this.score = score;
			this.count = count;
			this.time = time;
		}

		@Override
		public int compareTo(Team o) {
			if(this.score == o.score) {
				if(this.count == o.count) {
					if(this.time < o.time)
						return -1;
					else if(this.time > o.time)
						return 1;
				}
				return this.count - o.count;
			}
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for(int a=0;a<T;a++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 팀 수
			k = Integer.parseInt(st.nextToken()); // 문제 수
			t = Integer.parseInt(st.nextToken()); // 팀 id
			m = Integer.parseInt(st.nextToken()); // 로그 엔트리 수

			teams = new ArrayList<>();
			scores = new int[n+1][k+1];
			counts = new int[n+1];
			times = new int[n+1];

			for(int b=0;b<m;b++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken()); // 팀 id
				int j = Integer.parseInt(st.nextToken()); // 문제 번호
				int s = Integer.parseInt(st.nextToken()); // 획득한 점수

				counts[i]++;
				times[i] = b;
				if(scores[i][j] != 0) {
					scores[i][j] = Math.max(scores[i][j], s);
				} else scores[i][j] = s;
			}

			for(int b=1;b<n+1;b++) {
				int sum = 0;
				for(int c=1;c<k+1;c++) {
					sum += scores[b][c];
				}
				teams.add(new Team(b, sum, counts[b], times[b]));
			}

			Collections.sort(teams);

			for(int b=0;b<n;b++) {
				if(teams.get(b).id == t) {
					sb.append(b+1).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}