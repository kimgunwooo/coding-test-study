import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Long> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }

        long min = 0;
        long max = Collections.max(arr);

        System.out.println(binary_search(m,min,max,arr));

    }
    public static long binary_search(int m,long min, long max, List<Long> arr){
        long mid=0;
        while(min<max){
            //중간 값 (= 자르는 위치)
            mid = (min+max)/2;
            long sum =0;

            for(Long tree : arr){
                //나무의 크기가 자르는 위치보다 작다면 = 음수
                if(tree-mid > 0){ //나무의 크기가 자르는 위치보다 커서 잘린다면 = 양수라면
                    //sum 변수에 잘린 나무의 길이 다 더함.
                    sum += (tree-mid);
                }
            }

            //잘린 나무의 길이를 모두 더한 값이 원하는 값보다 작다면?
            //=자르는 위치가 높다 -> 자르는 위치를 낮춰야 함.
            //max를 줄여야 한다.
            if(sum < m)
                max = mid;

            //잘린 나무의 길이를 모두 더한 값이 원하는 값보다 크다면?
            //=자르는 위치가 낮다 -> 올리자.
            //min을 올려야 한다.
            else{
                min = mid + 1;
            }
        }
        return min-1;
    }
}