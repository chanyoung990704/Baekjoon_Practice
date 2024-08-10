import java.util.*;
import java.util.stream.*;

class Solution {
    
    boolean[][] visited;
    int[] dy = new int[]{0,0,1,-1};
    int[] dx = new int[]{1,-1,0,0};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0 ; i < maps.length ; i++)
            for(int j = 0 ; j < maps[0].length() ; j++)
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    visited[i][j] = true;
                    list.add(dfs(i, j, maps));
                }        
        if(list.isEmpty()) return new int[]{-1};
        
        return list.stream()
            .mapToInt(Integer::valueOf)
            .sorted()
            .toArray();
    }
    
    int dfs(int y, int x, String[] maps){
        
        int ret = maps[y].charAt(x) - '0';
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length())
                if(!visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                    visited[ny][nx] = true;
                    ret += dfs(ny, nx, maps);
                }
                    
        }
        return ret;
        
    }
}