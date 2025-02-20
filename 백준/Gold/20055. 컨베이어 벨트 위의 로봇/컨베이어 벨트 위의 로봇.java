import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        // Read input
        List<Integer> NK = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
        int N = NK.get(0);
        int len = 2 * N;
        int K = NK.get(1);

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

        Deque<Integer> dq = new ArrayDeque<>(list); // Belt durability
        List<Integer> robots = new ArrayList<>();   // Robot positions
        int zeroCount = 0;                          // Count of zero-durability cells
        int step = 1;                               // Step counter

        while (true) {
            // 1. Rotate the belt and robots
            dq.offerFirst(dq.pollLast()); // Rotate belt
            robots = robots.stream().map(i -> (i + 1) % len)
                .collect(Collectors.toList());
            
            // Remove robot at position N-1 (down position)
            robots = robots.stream().filter(i -> i != N - 1)
                .collect(Collectors.toList());

            // 2. Move robots if possible
            List<Integer> dqList = new ArrayList<>(dq); // Convert deque to list for easier indexing
            for (int i = 0; i < robots.size(); i++) {
                int robot = robots.get(i);
                int next = (robot + 1) % len;

                // Check if next position is valid for movement
                if (!robots.contains(next) && dqList.get(next) > 0) {
                    robots.set(i, next); // Move robot
                    dqList.set(next, dqList.get(next) - 1); // Decrease durability

                    if (dqList.get(next) == 0) zeroCount++; // Update zero-durability count
                }
            }

            // Remove robot at position N-1 again after movement
            robots = robots.stream().filter(i -> i != N - 1)
                .collect(Collectors.toList());

            // 3. Add a new robot at position 0 if possible
            if (dqList.get(0) > 0) {
                robots.add(0); // Add robot at position 0
                dqList.set(0, dqList.get(0) - 1); // Decrease durability

                if (dqList.get(0) == 0) zeroCount++; // Update zero-durability count
            }

            // Update deque with modified durability values
            dq = new ArrayDeque<>(dqList);

            // 4. Check termination condition
            if (zeroCount >= K) break;

            step++;
        }

        System.out.println(step);
    }
}
