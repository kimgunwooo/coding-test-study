import java.io.*;
import java.util.*;

/**
 *
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	public static int p,m;
	public static List<Room> rooms = new ArrayList<>();
	public static String WAITING = "Waiting!";
	public static String STARTED = "Started!";

	public static class Room {
		String status;
		List<Player> players;

		public Room() {
			this.status = WAITING;
			this.players = new ArrayList<>();
		}

		public void addPlayer(Player player) {
			this.players.add(player);
			if(players.size() == m)
				this.status = STARTED;
		}
	}

	public static class Player implements Comparable<Player>{
		String name;
		int level;

		public Player(String name, int level) {
			this.name = name;
			this.level = level;
		}

		@Override
		public int compareTo(Player p) {
			return this.name.compareTo(p.name);
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");

		p = Integer.parseInt(st.nextToken()); // 플레이어 수
		m = Integer.parseInt(st.nextToken()); // 방의 정원

		for(int i=0;i<p;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int l = Integer.parseInt(st.nextToken()); // 플레이어 레벨
			String n = st.nextToken(); // 닉네임
			solution(l,n);
		}
		print();

		System.out.println(sb);
	}

	private static void solution(int level, String name) {
		boolean flag = false;

		for(Room room : rooms) {
			if(room.status.equals(STARTED)) {
				continue;
			}
			if(!room.players.isEmpty() && room.players.get(0).level - 10 <= level && level <= room.players.get(0).level + 10) {
				flag = true;
				room.addPlayer(new Player(name, level));
				break;
			}
		}

		if(!flag) {
			Room room = new Room();
			room.addPlayer(new Player(name, level));
			rooms.add(room);
		}
	}
	private static void print() {
		for(Room room : rooms) {
			Collections.sort(room.players);
			sb.append(room.status).append("\n");
			for(Player player : room.players) {
				sb.append(player.level).append(" ").append(player.name).append("\n");
			}
		}
	}
}