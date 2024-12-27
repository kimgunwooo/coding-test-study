import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 128 MB
 * ---
 * Robot X crashes into the wall: X번 로봇이 벽에 충돌하는 경우이다. 즉, 주어진 땅의 밖으로 벗어나는 경우가 된다.
 * Robot X crashes into robot Y: X번 로봇이 움직이다가 Y번 로봇에 충돌하는 경우이다.
 * OK
 * 각 명령의 반복 회수는 1이상 100이하
 *
 * x1,y1 -> x2,y2
 * 1,1 -> 4,1
 * 1,2 -> 3,1
 * 4,2 -> 3,4
 * 4,3 -> 2,4
 * y 부분이 B-y 로 구성됨.
 * x1 -> y2 = x1
 * y1 -> x2 = (B-y1)
 *
 * 여기서 각 방향에 따른 이동은?
 * W y2--
 * E y2++
 * N x2--
 * S x2++
 */

class Robot {
    int x;
    int y;
    int direction;
    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

class Command {
    int robotId;
    char command;
    int repeat;
    public Command(int robotId, char command, int repeat) {
        this.robotId = robotId;
        this.command = command;
        this.repeat = repeat;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int A,B,N,M;
    public static int[][] ground;
    public static List<Robot> robots;
    public static Queue<Command> commands;
    public static char[] direction = {'N', 'E', 'S', 'W'};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ground = new int[A+1][B+1];

        // 로봇의 초기 위치
        robots = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            for (int j=0; j<4; j++) {
                if (dir == direction[j]) {
                    robots.add(new Robot(x, y, j));
                }
            }
        }

        // 명령
        commands = new LinkedList<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            commands.offer(new Command(to, command, repeat));
        }

        while (!commands.isEmpty()) {
            // 명령을 하나씩 꺼내옴
            Command c = commands.poll();
            // 해당되는 로봇이 해당 명령을 수행함
            Robot robot = robots.get(c.robotId-1);
            for (int i=0; i<c.repeat; i++) {
                switch (c.command) {
                    case 'R':
                        robot.direction = robot.direction + 1 > 3 ? 0 : robot.direction + 1;
                        break;
                    case 'L':
                        robot.direction = robot.direction - 1 < 0 ? 3 : robot.direction - 1;
                        break;
                    case 'F':
                        switch (robot.direction) {
                            case 0:
                                robot.y++;
                                break;
                            case 1:
                                robot.x++;
                                break;
                            case 2:
                                robot.y--;
                                break;
                            case 3:
                                robot.x--;
                                break;
                        }
                }
                if (robot.x > A || robot.y > B || robot.x < 1 || robot.y < 1) {
                    System.out.printf("Robot %d crashes into the wall", c.robotId);
                    return;
                }
                for (int j=0; j<robots.size(); j++) {
                    if (j == c.robotId-1) continue;
                    if (robots.get(j).x == robot.x && robots.get(j).y == robot.y) {
                        System.out.printf("Robot %d crashes into robot %d", c.robotId, j+1);
                        return;
                    }
                }
            }

            // 벽에 부딪히거나 다른 로봇과 충돌한다면 오류를 내뱉고 종료
            // 모든 명령을 다 돌았다면 성공 OK
        }
        System.out.println("OK");
    }
}

/*
5 5
2 3
3 3 E
4 5 N
2 L 3
2 R 8
2 F 3
 */