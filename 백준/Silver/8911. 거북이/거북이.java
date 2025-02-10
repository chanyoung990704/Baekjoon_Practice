import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int T = Integer.valueOf(br.readLine());

        while (T -- > 0) {
            String input = br.readLine();

            List<List<Integer>> idxs = new ArrayList<>();
            idxs.add(List.of(0, 0));
            int y = 0;
            int x = 0;

            int[] dy = new int[]{1, 0, -1, 0};
            int[] dx = new int[]{0, 1, 0, -1};
            int dir = 0;

            for(char c : input.toCharArray()){
                if(c == 'F'){
                    y += dy[dir];
                    x += dx[dir];
                }else if(c == 'B'){
                    y -= dy[dir];
                    x -= dx[dir];
                }else if(c == 'L'){
                    dir -=  1;
                    if(dir < 0){
                        dir = 3;
                    }
                }else if(c == 'R'){
                    dir += 1;
                    if(dir > 3){
                        dir = 0;
                    }
                }

                if(c == 'F' || c == 'B'){
                    idxs.add(List.of(y, x));
                }
            }

            int maxY = 0;
            int minY = 0;
            int maxX = 0;
            int minX = 0;

            for(List<Integer> idx : idxs){
                if(idx.get(0) > maxY){
                    maxY = idx.get(0);
                }
                if(idx.get(0) < minY){
                    minY = idx.get(0);
                }
                if(idx.get(1) > maxX){
                    maxX = idx.get(1);
                }
                if(idx.get(1) < minX){
                    minX = idx.get(1);
                }
            }

            System.out.println(Math.abs(maxX - minX) * Math.abs(maxY - minY));
        }
    }
}


