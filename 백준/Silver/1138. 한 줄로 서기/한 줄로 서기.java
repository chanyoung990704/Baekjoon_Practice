import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] room = new int[N];

        for(int i = 0; i < N; i++) {
            int cnt = nums[i];
            // 빈 방 찾기
            for(int j = 0 ; j < N ; j++){
                if(room[j] == 0 && cnt == 0){
                    room[j] = i + 1;
                    break;
                }else if(room[j] == 0){
                    cnt--;
                }
            }
        }

        System.out.println(Arrays.stream(room)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
