import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Boolean> apple = new HashMap<>();
        Map<Integer, Character> dir = new HashMap<>();
        LinkedList<String> snake = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int[] idx = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            apple.put(idx[0] + "," + idx[1], true);
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] arr = br.readLine().split(" ");
            int t = Integer.parseInt(arr[0]);
            char d = arr[1].charAt(0);
            dir.put(t, d);
        }

        int time = 0;
        snake.add("1,1");
        int y = 1;
        int x = 1;
        char curDir = 'R';

        while (true) {
            time++;
            int[] afterMove = move(y, x, curDir);
            y = afterMove[0];
            x = afterMove[1];

            if (y <= 0 || y > N || x <= 0 || x > N) break;

            String cur = y + "," + x;
            if (snake.contains(cur)) break;

            snake.add(cur);

            if (apple.containsKey(cur)) {
                apple.remove(cur);
            } else {
                snake.removeFirst();
            }

            if (dir.containsKey(time)) {
                curDir = changeDirection(curDir, dir.get(time));
            }
        }

        System.out.println(time);

        br.close();
    }

    static int[] move(int y, int x, char direction) {
        switch (direction) {
            case 'R':
                x += 1;
                break;
            case 'L':
                x -= 1;
                break;
            case 'U':
                y -= 1;
                break;
            case 'D':
                y += 1;
                break;
        }
        return new int[]{y, x};
    }

    static char changeDirection(char current, char turn) {
        if (turn == 'D') {
            switch (current) {
                case 'R': return 'D';
                case 'D': return 'L';
                case 'L': return 'U';
                case 'U': return 'R';
            }
        } else if (turn == 'L') {
            switch (current) {
                case 'R': return 'U';
                case 'U': return 'L';
                case 'L': return 'D';
                case 'D': return 'R';
            }
        }
        return current;
    }
}