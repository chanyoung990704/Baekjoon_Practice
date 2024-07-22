import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현재 시간 파싱
        List<Integer> currentTime = Arrays
            .stream(br.readLine().split(":"))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        // 나트륨 던질 시간 파싱
        List<Integer> throwTime = Arrays
            .stream(br.readLine().split(":"))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        // 초 단위로 변환
        int currentSeconds = convertToSeconds(currentTime);
        int throwSeconds = convertToSeconds(throwTime);

        // 시간 차이 계산
        int diffSeconds = throwSeconds - currentSeconds;
        if (diffSeconds <= 0) {
            diffSeconds += 24 * 3600; // 24시간을 초 단위로 더함
        }

        // hh:mm:ss 형식으로 변환
        List<Integer> result = convertToHMS(diffSeconds);

        // 결과 출력
        for (int i = 0; i < 3; i++) {
            String s = result.get(i).toString();
            if (s.length() == 1) {
                s = "0" + s;
            }
            System.out.print(s);
            if (i != 2) {
                System.out.print(":");
            }
        }

        br.close();
    }

    // 시간을 초 단위로 변환하는 메서드
    static int convertToSeconds(List<Integer> time) {
        int h = time.get(0) * 3600;
        int m = time.get(1) * 60;
        int s = time.get(2);
        return h + m + s;
    }

    // 초를 hh:mm:ss 형식으로 변환하는 메서드
    static List<Integer> convertToHMS(int seconds) {
        List<Integer> time = new ArrayList<>();
        time.add(seconds / 3600);
        seconds %= 3600;
        time.add(seconds / 60);
        seconds %= 60;
        time.add(seconds);
        return time;
    }
}