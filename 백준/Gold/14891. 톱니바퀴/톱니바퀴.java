import java.io.*;
import java.util.*;

/**
 * 시간 제한 2초
 * 메모리 제한 512 MB
 * ---
 * 같은 극이면 그대로, 다른 극이면 반대 방향으로 회전
 *
 * 회전횟수 K(1 ≤ K ≤ 100)
 * 1은 시계, -1 반시계
 *
 * 4개 톱니바퀴, 8개
 */

class Rotation {
    int num;
    int command;
    public Rotation(int command, int num) {
        this.command = command;
        this.num = num;
    }
}

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    static boolean[][] gear = new boolean[4][8];
    public static void main(String[] args) throws IOException {
        //톱니바퀴 초기 상태 저장
        for(int i=0;i<4;i++){
            String state = br.readLine();
            setGear(i, state);
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken()) - 1;	//톱니바퀴 번호
            int direction = Integer.parseInt(st.nextToken());	//회전 방향
            startGear(n, direction);	//시뮬레이션 진행!
        }

        int answer = gearCheck();	//톱니바퀴 점수 구하기!
        System.out.println(answer);
    }
    //톱니바퀴 점수 구하는 함수
    static int gearCheck(){
        int answer = 0;
        //각 톱니바퀴의 12시 방향 극 확인
        for(int i=0;i<4;i++){
            if(gear[i][0])	//S극일 때
                answer += Math.pow(2, i); //점화식을 이용하여 더하기!
        }
        return answer;	//톱니바퀴 점수 반환
    }

    static void startGear(int index, int direction){
        boolean magnet = gear[index][2];	//기준 톱니바퀴 3시 방향의 극
        int nDirection = direction;
        //기준 톱니바퀴 오른쪽에 있는 톱니바퀴들 탐색
        for(int i=index+1;i<4;i++){
            if(gear[i][6] != magnet){	//마주보는 극이 다를 때
                magnet = gear[i][2];	//다음 톱니바퀴를 탐색하기 위해 변경
                nDirection *= -1;	//방향 변경
                rotate(i, nDirection);	//회전 진행
            }else
                break;
        }
        magnet = gear[index][6];	//기준 톱니바퀴 9시 방향의 극
        nDirection = direction;
        //기준 톱니바퀴 왼쪽에 있는 톱니바퀴들 탐색
        for(int i=index-1;i>=0;i--){
            if(gear[i][2] != magnet){	//마주보는 극이 다를 때
                magnet = gear[i][6];	//다음 톱니바퀴를 탐색하기 위해 변경
                nDirection *= -1;	//방향 변경
                rotate(i, nDirection);	//회전 진행
            }else
                break;
        }
        rotate(index, direction);	//기준 톱니바퀴 회전 진행!
    }
    //톱니바퀴 회전 진행하는 함수
    static void rotate(int index, int rotate){
        boolean temp;
        //시계방향 회전
        if(rotate == 1){
            temp = gear[index][7];
            for(int i=7;i>0;i--)
                gear[index][i] = gear[index][i-1];
            gear[index][0] = temp;
        }else{		//반시계방향 회전
            temp = gear[index][0];
            for(int i=0;i<7;i++)
                gear[index][i] = gear[index][i+1];
            gear[index][7] = temp;
        }
    }
    //초기 톱니바퀴 값들 저장하는 함수
    static void setGear(int index, String state){
        for (int i=0;i<8;i++){
            if (state.charAt(i) == '1')	//S극 : True
                gear[index][i] = true;
            else		//N극 : False
                gear[index][i] = false;
        }
    }
}
