import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int N = Integer.valueOf(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int res = 0;
        while (list.size() > 1) {
            // 가장 큰 값을 갖는 idx 찾기
            int idx = 0;
            for(int i = 1 ; i < list.size() ; i++){
                if(list.get(idx) < list.get(i)){
                    idx = i;
                }
            }

            // 가장 왼쪽에 위치
            if(idx == 0){
                // 오른쪽과 비교
                res += Math.abs(list.get(idx) - list.get(idx + 1));
            }else if(idx == list.size() - 1){
                // 왼쪽과 비교
                res += Math.abs(list.get(idx) - list.get(idx - 1));
            }else{
                // 왼쪽 오른쪽 비교 후 최소 선택
                int left = Math.abs(list.get(idx) - list.get(idx - 1));
                int right = Math.abs(list.get(idx) - list.get(idx + 1));
                res += Math.min(left, right);
            }
            
            // 제거
            list.remove(idx);
        }

        System.out.println(res);
    }
}

