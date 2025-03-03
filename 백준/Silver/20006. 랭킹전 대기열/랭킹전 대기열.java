import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        int[] pm = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf).toArray();

        int p = pm[0];
        int m = pm[1];

        Map<Integer, List<String>> game = new LinkedHashMap<>(); // 방
        Map<String, Integer> player = new HashMap<>(); // 플레이어 
        int roomId = 0;

        for(int i = 0 ; i < p ; i++) {
            // 입력
            String[] input = br.readLine().split(" ");
            int level = Integer.valueOf(input[0]);
            String nickname = input[1];

            player.put(nickname, level);

            // 방 찾기
            boolean find = false;
            for(Map.Entry<Integer, List<String>> e : game.entrySet()){
                List<String> v = e.getValue();
                if(!v.isEmpty() && v.size() < m){
                    int roomLevel = player.get(v.get(0));
                    if(Math.abs(roomLevel - level) <= 10){
                        // 입장
                        v.add(nickname);
                        find = true;
                        break;
                    }
                }
            }

            // 방에 입장못했으면 방만들기
            if(!find){
                game.put(roomId++, new ArrayList<>(Arrays.asList(nickname)));
            }

        }

        for(Map.Entry<Integer, List<String>> e : game.entrySet()){
            // 정원이면
            List<String> v = e.getValue();
            if(v.size() == m){
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }

            // 정렬 뒤 출력
            v.sort(Comparator.naturalOrder());

            for(String n : v){
                System.out.println(player.get(n) + " " + n);
            }
        }

    }
}



