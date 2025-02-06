import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        List<Integer> HW = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int H = HW.get(0);
        int W = HW.get(1);

        List<String> joi = new ArrayList<>();
        for(int i = 0 ; i < H ; i++){
            joi.add(br.readLine());
        }

        // c있는 좌표 찾기
        List<List<Integer>> idx = new ArrayList<>();
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                if(joi.get(i).charAt(j) == 'c'){
                    idx.add(List.of(i, j));
                }
            }
        }

        // 최종결과
        int[][] res = new int[H][W];
        for(int i = 0 ; i < H ; i++){
            Arrays.fill(res[i], -1);
        }

        int time = 0;
        for(int i = 0 ; i < W ; i++){
            for(List<Integer> c : idx){
                int y = c.get(0);
                int x = c.get(1) + i;

                if(y >= 0 && y < H && x >= 0 && x < W){
                    if(res[y][x] == -1){
                        res[y][x] = time;
                    }else if(res[y][x] >= 0){
                        res[y][x] = Math.min(res[y][x], time);
                    }
                }
            }
            time++;
        }

        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                System.out.print(res[i][j]);
                if(j < W - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

