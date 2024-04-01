import java.util.*;

/**
각 직선마다 교점이 존재하는지 검사를 해줘야 할 것
정수에 대해서만 저장

한번 겹친 다른 직선에 대해서는 검사 안해줘도 됨. (직선이니까 2번 겹칠일이 없음)
구한 x,y의 최대값으로 배열의 크기를 결정해주고, 찍기
*/

class Point {
    long x;
    long y;
    
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        for(int i=0; i<line.length; i++) {
            for(int j=i+1; j<line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                
                if(intersection == null) continue;
                points.add(intersection);
            }
        }
        
        Point minXY = minPoint(points);
        Point maxXY = maxPoint(points);
        
        int width = (int)(maxXY.x - minXY.x + 1);
        int height = (int)(maxXY.y - minXY.y + 1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row,'.');
        }
        
        for(Point p : points) {
            int x = (int)(p.x - minXY.x);
            int y = (int)(maxXY.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
    
    private Point intersection(int a, int b, int e, int c, int d, int f) {
        double x = (double) ((long)b*(long)f - (long)e*(long)d) / ((long)a*(long)d - (long)b*(long)c);
        double y = (double) ((long)e*(long)c - (long)a*(long)f) / ((long)a*(long)d - (long)b*(long)c);
        
        if(x%1 != 0 || y%1 != 0) return null;
        else return new Point((long)x,(long)y); // 정수라면
    }
    
    private Point minPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            x = Math.min(p.x, x);
            y = Math.min(p.y, y);
        }
        return new Point(x,y);
    }
    
    private Point maxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            x = Math.max(p.x, x);
            y = Math.max(p.y, y);
        }
        return new Point(x,y);
    }
}