class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int zero_cnt = 0;
        for(int i=0;i<lottos.length;i++) {
            if(lottos[i]==0){
                zero_cnt++;
                continue;
            }
                
            
            for(int j=0;j<win_nums.length;j++) {
                if(lottos[i]==win_nums[j])
                    cnt++;
            }
        }
        
        
        answer[0] = cnt+zero_cnt;
        answer[1] = cnt;
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        for(int i=0;i<2;i++){
            if(answer[i] < 0 || answer[i] > 7)
                answer[i] = 6;
            answer[i] = rank[answer[i]];
        }
        
        return answer;
    }
}