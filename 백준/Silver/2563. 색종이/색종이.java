import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        boolean[][] visited = new boolean[100][100];
        int cnt = 0;

        for(int i = 0 ; i < N ; i++) {
            List<Integer> l = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

            for(int j = l.get(0) ; j < l.get(0) + 10 ; j++)
                for(int k = l.get(1) ; k < l.get(1) + 10 ; k++)
                    if(!visited[j][k]){
                        cnt++;
                        visited[j][k] = true;
                    }
        }

        System.out.println(cnt);
    }
}