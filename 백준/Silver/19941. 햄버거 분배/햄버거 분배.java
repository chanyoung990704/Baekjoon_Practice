import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NK.get(0);
        int K = NK.get(1);

        String input = br.readLine();

        boolean[] eat = new boolean[20000 + 1];
        int cnt = 0;

        for(int i = 0 ; i < input.length() ; i++){
            char cur = input.charAt(i);

            // 사람이면 햄버거 찾기
            if(cur == 'P'){
                boolean search = false;
                // 왼쪽 탐색
                for(int j = i - K ; j < i ; j++){
                    if(j < 0) continue; 
                    if(!eat[j] && input.charAt(j) == 'H'){
                        search = true;
                        eat[j] = true;
                        break;
                    }
                }
                // 오른쪽 탐색 필요있으면 탐색
                if(!search){
                    for(int j = i + 1 ; j <= i + K ; j++){
                        if(j >= input.length()) break;
                        if(!eat[j] && input.charAt(j) == 'H'){
                            search = true;
                            eat[j] = true;
                            break;
                        }
                    }
                }

                // 햄버거 먹었으면 개수 추가
                if(search) cnt++;
            }
        }

        System.out.println(cnt);


        br.close();

    }
}
