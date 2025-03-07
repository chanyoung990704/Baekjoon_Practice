import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int sum = 0;
        int prev = 0;
        int[] winningTime = new int[3];
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);

            if(sum > 0){
                winningTime[1] += stringToInt(input[1]) - prev;
            }else if(sum < 0){
                winningTime[2] += stringToInt(input[1]) - prev;
            }

            if(team == 1) {
                sum++;
            }else if(team == 2) {
                sum--;
            }
            prev = stringToInt(input[1]);
        }

        if(sum > 0){
            winningTime[1] += stringToInt("48:00") - prev;
        }else if(sum < 0){
            winningTime[2] += stringToInt("48:00") - prev;
        }

        System.out.println(intToString(winningTime[1]) + "\n" + intToString(winningTime[2]));

    }

    static int stringToInt(String time) {
        List<Integer> list = Arrays.stream(time.split(":"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return list.get(0) * 60 + list.get(1);
    }

    static String intToString(int time) {
        StringBuilder h = new StringBuilder();
        StringBuilder m = new StringBuilder();

        h.append(time / 60);
        if(h.length() < 2){
            String zero = "0".repeat(2 - h.length());
            h = new StringBuilder(zero + h.toString());
        }
        m.append(time % 60);
        if(m.length() < 2){
            String zero = "0".repeat(2 - m.length());
            m = new StringBuilder(zero + m.toString());
        }

        return h.toString() + ":" + m.toString();
    }
}
