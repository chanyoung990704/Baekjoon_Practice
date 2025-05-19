import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Main {

    static class MeetingRoom {
        int start;
        int end;

        public MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<MeetingRoom> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rooms.add(new MeetingRoom(se[0], se[1]));
        }

        rooms.sort(Comparator.comparing((MeetingRoom r) -> r.start)
                .thenComparing(r -> r.end));

        PriorityQueue<MeetingRoom> pq = new PriorityQueue<>(Comparator.comparing((MeetingRoom r) -> r.end));

        for (int i = 0; i < rooms.size(); i++) {
            if (i == 0) {
                pq.offer(rooms.get(i));
                continue;
            }

            MeetingRoom room = rooms.get(i);
            if (room.start >= pq.peek().end) {
                pq.poll();
            }
            pq.add(room);
        }

        System.out.println(pq.size());

    }
}
