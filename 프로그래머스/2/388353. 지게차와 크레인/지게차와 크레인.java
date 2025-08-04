import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        StringBuilder[] sb = new StringBuilder[storage.length];
        for(int i = 0 ; i < sb.length ; i++){
            sb[i] = new StringBuilder(storage[i]);
        }
        
        for(String req : requests){
            if(req.length() == 1){
                edgeDelete(sb, req);
            }
            else if(req.length() == 2){
                allDelete(sb, req);
            }
        }
        

        for(int i = 0 ; i < sb.length ; i++){
            for(int j = 0 ; j < sb[0].length() ; j++){
                if(sb[i].charAt(j) >= 'A' && sb[i].charAt(j) <= 'Z'){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    
    void bfs(StringBuilder[] sb, int y, int x, List<int[]> idx, char c){
        int[] dy = new int[]{0,0,1,-1};
        int[] dx = new int[]{1,-1,0,0};
        
        boolean[][] visited = new boolean[sb.length][sb[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 4방향 확인
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < sb.length && nx >= 0 && nx < sb[0].length()){
                    if(sb[ny].charAt(nx) == c){
                        idx.add(new int[]{ny, nx});
                    }
                }
            }
            
            // 빈칸 이동
            for(int i = 0 ; i < 4;  i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny >= 0 && ny < sb.length && nx >= 0 && nx < sb[0].length()){
                    if(!visited[ny][nx] && sb[ny].charAt(nx) == 'x'){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
    
    void edgeDelete(StringBuilder[] sb, String req){
        char c = req.charAt(0);
        List<int[]> idx = new ArrayList<>();
        
        // 테두리인 경우
        for(int i = 0 ; i < sb.length ; i++){
            for(int j = 0 ; j < sb[0].length() ; j++){
                if(i == 0 || i == sb.length - 1 || j == 0 || j == sb[0].length() - 1 ){
                    if(sb[i].charAt(j) == c){
                        idx.add(new int[]{i, j});
                    }else if(sb[i].charAt(j) == 'x'){
                        bfs(sb, i, j, idx,c);
                    }
                }
            }
        }
        
        for(int[] i : idx){
            sb[i[0]].setCharAt(i[1], 'x');
        }
        
    }
    
    void printSb(StringBuilder[] sb){
        for(int i = 0 ; i < sb.length ;i++){
            System.out.println(sb[i].toString());
        }
    }
    
     void allDelete(StringBuilder[] sb, String req){
         char c = req.charAt(0);
         for(int i = 0 ; i < sb.length ; i++){
             for(int j = 0 ; j < sb[i].length() ; j++){
                 if(sb[i].charAt(j) == c){
                     sb[i].setCharAt(j, 'x');
                 }
             }
         }
     }
}