import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<Integer> crain = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf)
            .sorted(Collections.reverseOrder())  
            .collect(Collectors.toList());

        int M = Integer.valueOf(br.readLine());
        List<Integer> box = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf)
            .sorted(Collections.reverseOrder())  
            .collect(Collectors.toList());

        // 크레인의 최대 값으로도 상자를 못 담는 경우
        if(crain.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while(!box.isEmpty()) {
            int boxIdx = 0;
            for(int i = 0; i < N && boxIdx < box.size(); i++) {
                // 현재 크레인이 들 수 있는 가장 무거운 박스를 찾음
                while(boxIdx < box.size() && box.get(boxIdx) > crain.get(i)) {
                    boxIdx++;
                }
                if(boxIdx < box.size()) {
                    box.remove(boxIdx);
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
