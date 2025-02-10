import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> RC = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int R = RC.get(0);
        int C = RC.get(1);

        // 현재 지도
        char[][] curMap = new char[R][C];
        for(int i = 0 ; i < R ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < input.length() ; j++){
                curMap[i][j] = input.charAt(j);
            }
        }

        // 이후 지도
        char[][] newMap = new char[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                newMap[i][j] = curMap[i][j];
            }
        }

        // 50년 후에 남아있는 땅 찾기
        List<List<Integer>> idxs = new ArrayList<>();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(curMap[i][j] == 'X'){
                    // 상하좌우 확인
                    int cnt = 0;
                    int[] dy = new int[]{0,0,1,-1};
                    int[] dx = new int[]{1,-1,0,0};

                    for(int dir = 0 ; dir < 4 ; dir++){
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];
                        if(ny<0||ny>=R||nx<0||nx>=C){
                            cnt++;
                            continue;
                        }else if(curMap[ny][nx] == '.'){
                            cnt++;
                        }
                    }

                    if(cnt < 3){
                        idxs.add(List.of(i, j));
                    }else{
                        newMap[i][j] = '.';
                    }
                }
            }
        }

        List<Integer> yList = idxs.stream().map(i -> i.get(0))
        .collect(Collectors.toList());
        List<Integer> xList = idxs.stream().map(i -> i.get(1))
        .collect(Collectors.toList());

        int minX = Collections.min(xList);
        int maxX = Collections.max(xList);
        int minY = Collections.min(yList);
        int maxY = Collections.max(yList);

        for(int i = minY ; i <= maxY ; i++){
            for(int j = minX ; j <= maxX ; j++){
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }
    }
}


