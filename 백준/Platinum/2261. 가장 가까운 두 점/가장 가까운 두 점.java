import java.io.*;
import java.util.*;

class Main {
    private static Point[] p;
    private static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    //두 Point의 거리를 반환하는 메소드
    private static int dist(Point o1, Point o2){
        return (o1.x-o2.x)*(o1.x-o2.x) + (o1.y-o2.y)*(o1.y-o2.y);
    }

    /*
    Y좌표를 오름차순으로 정렬하는 Comparator 익명 객체
    내부에 람다식으로 만들면 매 번 객체를 생성해주어야 하기 때문에 - 시간낭비
    일회성이 아닌 이상 람다식은 어지간하면 안씀.
     */
    private static Comparator<Point> Ycomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.y-o2.y;
        }
    };
    // X좌표를 오름차순으로 정렬하는 Comparator 익명 객체
    private static Comparator<Point> Xcomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x-o2.x;
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        p = new Point[n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            p[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(p,Xcomp);

        System.out.println(closest(0,n-1));
    }
    //브루트포스 방식
    private static int brute(int start, int end){
        int minDist = Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            Point x0 = p[i];
            for(int j=i+1;j<=end;j++){
                minDist = Math.min(minDist,dist(x0,p[j]));
            }
        }
        return minDist;
    }
    //분할정복을 할 메소드
    private static int closest(int start, int end){
        //p[start] ~ p[end] 원소가 3개 이하라면 브루트포스로 거리 반환
        if(end-start+1 < 4){
            return brute(start, end);
        }

        //가운데 index를 구함
        int mid = (start + end)/2;

        // 왼쪽 오른쪽을 분할해서 탐색색
        int left = closest(start, mid);
        int right = closest(mid+1, end);

        //각 각의 거리 중 최솟값을 구한 뒤 반환
        int minDist = Math.min(left,right);
        
        // 중간 영역의 최소 거리
        int band = middleBand(start,mid,end,minDist);
        return Math.min(minDist,band);
    }
    // 중간 Band 영역에서 최소거리 구하기
    static int middleBand(int start, int mid, int end, int minDist){
        int xDist;

        //index 참조가 많기에 ArrayList를 활용
        ArrayList<Point> list = new ArrayList<>();

        //후보군 추출하기
        int midX = p[mid].x; //mid 인덱스의 x좌표 값
        for(int i = start;i<=end;i++){
            xDist = p[i].x-midX; //x좌표 차이

            if(xDist*xDist < minDist){
                list.add(p[i]);
            }
        }
        //후보군들을 y좌표 기준으로 정렬
        Collections.sort(list,Ycomp);

        //후보군들을 순회하면서 y좌표 차이가 midDist내에 있는 원소들만 거리 측정
        int yDist;
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                /*
                i번째 점과 j번째 점을 비교해 y좌표거리를 측정한다.
                측정된 y좌표거리가 minDist보다 작다면?
                i,j 점의 거리를 측정하여 midDist와 측정한 거리 중
                작은 값으로 갱신
                 */
                yDist = list.get(i).y - list.get(j).y;
                if(yDist*yDist < minDist){
                    minDist = Math.min(minDist,dist(list.get(i),list.get(j)));
                }
                /*
                그 외는 y좌표 차이가 midDest보다 크다는 의미로 i 번째 원소에 대한
                측정을 멈추고 다음 점으로 넘어감.
                 */
                else{
                    break;
                }
            }
        }
        return minDist;
    }

}