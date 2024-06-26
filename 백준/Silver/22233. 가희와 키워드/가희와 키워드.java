import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 현재까지 쓴 키워드가 모두 다르며, N 개 존재
 * 새 글을 작성할 때, 최대 10개 키워드
 * 글을 작성할 때, 사용한 키워드는 제거
 *
 * N,M <= 200_000
 * 어디에 키워드를 저장할까? 중복이 안되고, 검색과 삭제가 빨라야함. Map
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int N,M,count;
	public static Map<String, Integer> keywords = new HashMap<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 메모장에 적은 키워드 수
		M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글의 개수
		count = N;

		for(int i=0;i<N;i++) {
			String keyword = br.readLine();
			keywords.put(keyword, 0); // 뒷 값은 필요없음
		}


		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(),",");
			while(st.hasMoreTokens()){
				String str = st.nextToken();
				solution(str);
			}
			sb.append(keywords.size()).append("\n");
		}
		System.out.println(sb);
	}

	private static void solution(String keyword) {
		if(keywords.containsKey(keyword)) {
			keywords.remove(keyword);
			count--;
		}
	}
}