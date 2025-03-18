

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정보 N 대여기간 L 벌금 F
        String[] NLF = br.readLine().split(" ");
        int N = Integer.parseInt(NLF[0]);
        String L = NLF[1];
        int F = Integer.parseInt(NLF[2]);

        List<String> records = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            records.add(br.readLine());
        }

        Map<String, Map<String, LocalDateTime>> map = new HashMap<>(); // 빌린 사람 -> <빌린 물건 -> 종료 시각>
        TreeMap<String, Long> punished = new TreeMap<>();

        // 기록 탐색
        for (String cur : records) {
            String[] parsed = cur.split(" ");

            String user = parsed[3];
            String stuff = parsed[2];

            // 날짜 만들기
            LocalDateTime date = getLocalDateTime(parsed[0], parsed[1]);

            if (map.containsKey(user) && map.get(user).containsKey(stuff)) {
                // 종료 시각 확인 및 벌금 계산
                LocalDateTime endTime = map.get(user).get(stuff);
                if (date.isAfter(endTime)) {
                    Duration duration = Duration.between(endTime, date); // 순서 변경
                    long minutes = duration.toMinutes();
                    punished.put(user, punished.getOrDefault(user, 0L) + minutes * F);
                }
                map.get(user).remove(stuff);
                continue;
            }

            // 대여 기록 추가
            LocalDateTime endTime = calculateEndTime(date, L);
            map.computeIfAbsent(user, k -> new HashMap<>()).put(stuff, endTime);
        }

        if (punished.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Map.Entry<String, Long> e : punished.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue());
            }
        }
    }

    private static LocalDateTime getLocalDateTime(String s, String s1) {
        String[] ymd = s.split("-");
        String[] hm = s1.split(":");

        List<Integer> i_ymd = Arrays.stream(ymd).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> i_hm = Arrays.stream(hm).map(Integer::parseInt).collect(Collectors.toList());

        return LocalDateTime.of(i_ymd.get(0), i_ymd.get(1), i_ymd.get(2), i_hm.get(0), i_hm.get(1));
    }

    private static LocalDateTime calculateEndTime(LocalDateTime startTime, String L) {
        String[] parsedL = L.split("/");
        int d = Integer.parseInt(parsedL[0]);
        int h = Integer.parseInt(parsedL[1].split(":")[0]);
        int m = Integer.parseInt(parsedL[1].split(":")[1]);

        return startTime.plusDays(d).plusHours(h).plusMinutes(m);
    }
}
