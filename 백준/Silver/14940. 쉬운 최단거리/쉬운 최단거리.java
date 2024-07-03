import java.io.*;
import java.util.*;

/**
 * 2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000
 * 시작 정점이 (x,y) 로 부터 동서남북 4방향으로 탐색을 진행해야 함.
 * BFS 를 사용해서 탐색하면서 갈 수 있는 길이라면(1) 결과 맵에 1씩 증가하는 값을 저장해야 할 것.
 * 초기화 값을 -1 로 두고, 초기 시작 좌표를 0으로 전 값에 +1로 업데이트 해주면 될 듯 하다.
 * 여기서 원래 0으로 못가는 길이 -1로 처리되있는것도 고려해주면 될듯.
 *
 * 반례 1. 0의 위치를 탐색해가면서 업데이트 해주려고해서 시작지점으로 부터 탐색하지 못하는 경우가 있을때 0의 자리도 -1로 출력하는 오류 발생
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int n, m;
	public static boolean[][] visited;
	public static Queue<Node> queue = new LinkedList<>();
	public static int[][] matrix;
	public static int[][] resultMap;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static class Node{
		int x;
		int y;
		int value;

		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로

		matrix = new int[n][m];
		resultMap = new int[n][m];
		visited = new boolean[n][m];

		for(int i = 0; i<n; i++) {
			Arrays.fill(resultMap[i], -1);
		}

		int x = 0,y = 0;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				matrix[i][j] = num;
				if(num == 2){
					x = i; y = j;
				}
			}
		}

		solution(x,y);
		print();

		System.out.println(sb);
	}

	private static void solution(int x, int y) {
		queue.offer(new Node(x,y,matrix[x][y]));
		visited[x][y] = true;
		resultMap[x][y] = 0;

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i=0;i<4;i++) {
				int mx = node.x + dx[i];
				int my = node.y + dy[i];
				if(mx >= 0 && mx < n && my >= 0 && my < m) {
					if(matrix[mx][my] == 1 && !visited[mx][my]) {
						resultMap[mx][my] = resultMap[node.x][node.y] + 1;
						queue.offer(new Node(mx, my, matrix[mx][my]));
						visited[mx][my] = true;
					}
				}
			}
		}
	}

	private static void print() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j] == 0) { // 0 처리
					sb.append(0).append(" ");
					continue;
				}
				sb.append(resultMap[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
}