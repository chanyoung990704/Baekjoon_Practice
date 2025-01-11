import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());
        int N = NM.get(0);
        int M = NM.get(1);

        List<List<Integer>> matrix = new ArrayList<>();
        for(int i = 0 ; i < N ; i++)
            matrix.add(Arrays.stream(br.readLine().split(""))
            .map(Integer::valueOf).collect(Collectors.toList()));

        List<List<Integer>> origin = new ArrayList<>();
        for(int i = 0 ; i < N ; i++)
            origin.add(Arrays.stream(br.readLine().split(""))
            .map(Integer::valueOf).collect(Collectors.toList()));        

        int cnt = 0;

        while (true) {
            // 다음 번의 틀린 위치 찾기
            int y = 0;
            int x = 0;
            boolean f = false;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++)
                    if(matrix.get(i).get(j) != origin.get(i).get(j)){
                        y = i;
                        x = j;
                        f = true;
                        break;
                    }
                    if(f) break;
                }

            if(!f) break;

            // 3 * 3 이 되는지 확인
            if(y < 0 || y + 2 >= N || x < 0 || x + 2 >= M) break;

            // 업데이트
            for(int i = y ; i < y + 3 ; i++)
                for(int j = x ; j < x + 3 ; j++){
                    int val = (matrix.get(i).get(j) == 1) ? 0 : 1;
                    matrix.get(i).set(j, val);
                }
        
            cnt++;
        }
        

        // 전체가 같은지 확인
        boolean isAll = true;
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < M ; j++)
                if(matrix.get(i).get(j) != origin.get(i).get(j)){
                    isAll = false;
                    break;
                }

        if (isAll) {
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }

    }
}
