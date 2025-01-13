import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        int[][] coins = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String cur = br.readLine();
            for(int j = 0 ; j < cur.length() ; j++){
                char c = cur.charAt(j);
                if(c == '1'){
                    coins[i][j] = 1;
                }
            }
        }

        int cnt = 0;

        // 맨 뒤부터 확인
        for(int i = N - 1 ; i >= 0 ; i--){
            for(int j = M - 1 ; j >= 0 ; j--){
                // 현재가 1이면 뒤집기
                if(coins[i][j] == 1){
                    // 자기 자신 포함 뒤집기
                    for(int k = i ; k >= 0 ; k--){
                        for(int l = j ; l >= 0 ; l--){
                            coins[k][l] = (coins[k][l] == 1) ? 0 : 1;
                        }
                    }
                    // 카운팅
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
