/*
book_time의 길이는 최대 1_000;
객실의 개수도 최대 1_000이다.

아이디어 1. (누적합)
예약 시간을 int로 변환해서 배열에 시작시간과 끝 시간 사이의 값을 1씩 증가.
배열에서 최대 크기를 구해 반환.

아이디어 2. 
시간에 따른 오름차순 정렬을 해준다.
예약 시간을 int 형식으로 바꾼다.
처음 값 삽입. 이후 저장되어있는 종료시간과 받아온 시작값을 비교해서 해당 시간에 예약이 가능하다면 빼고, 불가능하다면 유지.
매 반복마다 종료시간이 가장 적은 값으로 업데이트해줘야 함.
*/

class Solution {
    public int solution(String[][] book_time) {
        int[] time_table = new int[24 * 60 + 10];
        
        for (String[] time : book_time) {
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            int startHour = Integer.parseInt(start[0]) * 60;
            int startMin = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]) * 60;
            int endMin = Integer.parseInt(end[1]) + 10;
            
            time_table[startHour+startMin]++;
            time_table[endHour+endMin]--;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i=1; i<time_table.length; i++) {
            time_table[i] += time_table[i-1];
            max = Math.max(max, time_table[i]);
        }
        
        return max;
    }
}