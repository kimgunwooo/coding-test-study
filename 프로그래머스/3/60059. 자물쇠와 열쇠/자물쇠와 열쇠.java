/*
* 오른쪽 90도 회전 = x,y -> 
* 오른쪽 180도 회전 = x,y -> (n-x)(n-y)
* // 270 = x,y -> (x+1)(y+1)
*/

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int m = key.length;
        int n = lock.length;
        
        lock = expand(n,m,lock);
        
        // for(int i = 0 ; i < n+(m-1)*2 ; i++){
        //     for(int j = 0 ; j < n+(m-1)*2 ; j++)
        //         System.out.print(lock[i][j]);
        //     System.out.println("");
        // }
            
        for(int i=0;i<4;i++) {
            if(i != 0) key = rotate(m, key);
            if(go(key,lock,m,n)) {
                answer = true;
                break;
            }
        }
        
        return answer;
    }
    
    public boolean go(int[][] key, int[][] lock, int m, int n){
        for(int i=0; i<m+n-1; i++){
            for(int j=0; j<m+n-1; j++){
                
                // key값 더하기
                for(int x=0; x<m; x++){
                    for(int y=0; y<m; y++){
                        lock[i+x][j+y] += key[x][y];
                    }
                }
                
                // lock범위 모두 1인지 확인
                boolean check = true;
                for(int x=m-1; x<n+m-1; x++){
                    for(int y=m-1; y<n+m-1; y++){
                        if(lock[x][y] != 1){
                            check = false;
                            break;
                        }
                    }
                }
                
                if(check){
                    return true;
                }
                
                // key값 뺴기
                for(int x=0; x<m; x++){
                    for(int y=0; y<m; y++){
                        lock[i+x][j+y] -= key[x][y];
                    }
                }
            }
        }
        return false;
    }
    
    public int[][] expand(int n, int m, int[][] lock){
        int wide = (m-1);
        int[][] expandedLock = new int[n+wide*2][n+wide*2];
        for(int i = wide ; i < n+wide ; i++)
            for(int j = wide ; j < n+wide ; j++)
                expandedLock[i][j] = lock[i-wide][j-wide];
        return expandedLock;
    }
    
    public int[][] rotate(int m, int[][] key){
        int[][] newKey = new int[m][m];
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < m ; j++)
                newKey[i][j] = key[m-1-j][i];
        return newKey;
    }
}