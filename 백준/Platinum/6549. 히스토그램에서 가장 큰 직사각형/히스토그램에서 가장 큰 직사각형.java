import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }
            histogram = new int[n];

            for(int i=0;i<n;i++){
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0,n-1)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int lo, int hi){
        //막대의 폭이 1일 경우 높이가 넓이가 되기에 바로 반환
        if(lo==hi){
            return histogram[lo];
        }

        //1번
        int mid = (lo+hi)/2;

        //2번
        long leftArea = getArea(lo,mid);
        long rightArea = getArea(mid+1,hi);

        //3번
        long max = Math.max(leftArea,rightArea);

        //4번 - 양쪽 구간 중 큰 값과 중간 구간을 비교하여 더 큰 넓이로 갱신
        max = Math.max(max,getMidArea(lo,hi,mid));

        return max;
    }
    //중간 지점 영역의 넓이를 구하는 메소드
    public static long getMidArea(int lo, int hi, int mid){
        int toLeft = mid; //중간 지점으로부터 왼쪽으로 갈 변수
        int toRight = mid; //중간 지점으로부터 오른쪽으로 갈 변수

        long height = histogram[mid]; //높이

        //초기 넓이는 구간폭이 1이기에 높이가 넓이
        long maxArea = height;

        //양 끝 범위를 벗어나기 전까지 반복
        while(lo<toLeft && hi > toRight){
            /*
            양쪽 다음칸의 높이 중 높은거 선택,
            단 갱신되는 height는 기존 height보다 작거나 같아야 함.
             */
            if(histogram[toLeft-1] < histogram[toRight+1]){
                toRight++;
                height = Math.min(height,histogram[toRight]);
            }
            else{
                toLeft--;
                height = Math.min(height,histogram[toLeft]);
            }
            //최대 넓이 갱신
            maxArea = Math.max(maxArea,height*(toRight - toLeft + 1));
        }

        //오른쪽 구간을 끝까지 탐색 못했다면 마저 탐색
        while(toRight < hi){
            toRight++;
            height = Math.min(height,histogram[toRight]);
            maxArea = Math.max(maxArea,height*(toRight - toLeft + 1));
        }
        //왼쪽 구간을 끝까지 탐색 못했다면 마저 탐색
        while(toLeft > lo){
            toLeft--;
            height = Math.min(height,histogram[toLeft]);
            maxArea = Math.max(maxArea,height*(toRight - toLeft + 1));
        }

        return maxArea;
    }

}