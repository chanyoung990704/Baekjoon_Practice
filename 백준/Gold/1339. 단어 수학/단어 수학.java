import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine());
        }


        Map<Character, Integer> map = new HashMap<>();

        // 전체 단어 돌면서 가중치 구하기
        for(String str : list){
            int val = 1;
            for(int i = str.length() - 1 ; i >= 0 ; i--){
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + val);
                val *= 10;
            }
        }

        List<Integer> values = map.values().stream()
        .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int total = 0;
        int val = 9;
        for(int cur : values){
            total += (cur * val);
            val--;
        }

        System.out.println(total);
    }
}
