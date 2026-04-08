import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n, int[][] data) {
        
        /////////////좌표 압축////////////////////////////
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] d : data){
            set.add(d[0]);
            set.add(d[1]);
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int s : set){
            map.put(s, ++rank);
        }
        
        /////////////////2차원 누적합//////////////////////////////
        
        int[][] sum = new int[rank+1][rank+1];
        for(int[] d : data){
            int x = map.get(d[0]);
            int y = map.get(d[1]);
            
            sum[x][y] = 1;
        }
        
        for(int i = 1 ; i <= rank ; i++){
            for(int j = 1; j <= rank ; j++){
                sum[i][j] += (sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]);
            }
        }
        
        
        ///////////////////개수 계산//////////////
        
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i +1 ; j < n ; j++){
                int[] f = data[i], s = data[j];
                
                // 직사각형x
                if(f[0] == s[0] || f[1] == s[1]){
                    continue;
                }
                
                int x1 = map.get(f[0]), x2 = map.get(s[0]);
                int y1 = map.get(f[1]), y2 = map.get(s[1]);
                
                int minX = Math.min(x1,x2), maxX = Math.max(x1,x2);
                int minY = Math.min(y1,y2), maxY = Math.max(y1,y2);
                
                
                int cnt =sum[maxX - 1][maxY - 1] - sum[minX][maxY - 1] - sum[maxX - 1][minY] + sum[minX][minY];
                
                
                if(cnt == 0){
                    answer++;
                }
                
                
                
            }
        }
        
        

        
        
        
        
        
        return answer;
    }
}